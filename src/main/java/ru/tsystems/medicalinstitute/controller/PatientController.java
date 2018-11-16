package ru.tsystems.medicalinstitute.controller;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.tsystems.medicalinstitute.bo.Patient;
import ru.tsystems.medicalinstitute.bo.Visit;
import ru.tsystems.medicalinstitute.service.MedicalCaseService;
import ru.tsystems.medicalinstitute.service.MedicalStaffService;
import ru.tsystems.medicalinstitute.service.PatientService;
import ru.tsystems.medicalinstitute.service.VisitService;

import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Controller
public class PatientController {
    private final PatientService patientService;
    private final MedicalCaseService medicalCaseService;
    private final VisitService visitService;
    private final MedicalStaffService medicalStaffService;

    private final SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");

    public PatientController(final PatientService patientService, final MedicalCaseService medicalCaseService,
                             final VisitService visitService, final MedicalStaffService medicalStaffService) {
        this.patientService = patientService;
        this.medicalCaseService = medicalCaseService;
        this.visitService = visitService;
        this.medicalStaffService = medicalStaffService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homePage() {
        return "redirect:/patients";
    }

    @RequestMapping(value = "/patients", method = RequestMethod.GET)
    public String listPatients(@RequestParam(required = false, defaultValue = "") String surname,
                               @RequestParam(required = false, defaultValue = "") String birthday,
                               @RequestParam(required = false, defaultValue = "") String caseNumber,
                               Model model) throws ParseException {

        model.addAttribute("surname", surname);
        model.addAttribute("birthday", birthday);
        model.addAttribute("caseNumber", caseNumber);
        model.addAttribute("listPatients", patientService.filterPatients(surname.toLowerCase(), birthday, caseNumber.toLowerCase()));

        return "patients";
    }

    @RequestMapping(value = "/patient", method = RequestMethod.GET)
    public String addPatient(Model model) {
        Patient patient = new Patient();
        model.addAttribute("patient", patient);

        return "patient";
    }

    @RequestMapping(value = "/patient-details/{id}", method = RequestMethod.GET)
    public String detailPatient(@PathVariable("id") int id, Model model) {
        model.addAttribute("patient", patientService.getById(id));
        model.addAttribute("visits", visitService.getByPatientId(id));
        model.addAttribute("medicalCases", medicalCaseService.getByPatientId(id));
        model.addAttribute("patientStatus", patientService.getPatientStatus(id));

        return "patient-details";
    }

    @RequestMapping(value = "/patient-details/{patientId}/new-visit", method = RequestMethod.GET)
    public String newVisit(@PathVariable("patientId") int id, Model model) {
        model.addAttribute("patient", patientService.getById(id));
        model.addAttribute("visits", visitService.listVisits());
        model.addAttribute("medicalStaff", medicalStaffService.listMedicalStaff());
        model.addAttribute("medicalStaffId", "");

        return "visit";
    }

    @RequestMapping(value = "/patient-details/{patientId}/new-visit-beginning-time", method = RequestMethod.GET)
    public @ResponseBody
    List<String> getExistedTimes(
            @RequestParam(value = "medicalStaff", required = false) String medicalStaff,
            @RequestParam(value = "visitDate", required = false) String visitDate) throws ParseException {
        List<Visit> existedVisits;
        List<String> existedTimes = null;

        if (visitDate != null) {
            existedVisits = visitService.getByMedicalStaffAndVisitDate(Integer.parseInt(medicalStaff), visitDate);
            if (!existedVisits.isEmpty()) {
                existedTimes = new LinkedList<>();
                for (Visit visit : existedVisits) {
                    existedTimes.add(timeFormat.format(visit.getBeginningTime()));
                    existedTimes.add(timeFormat.format(visit.getEndingTime()));
                }
            }
        }

        return existedTimes;
    }

    @RequestMapping(value = "/patient-details/{patientId}/new-visit-ending-time", method = RequestMethod.GET)
    public @ResponseBody
    List<String> getEndingTime(
            @RequestParam(value = "medicalStaff", required = false) String medicalStaff,
            @RequestParam(value = "visitDate", required = false) String visitDate,
            @RequestParam(value = "beginningTime", required = false) String beginningTime) throws ParseException {
        List<Visit> existedVisits;
        List<String> existedTimes = new LinkedList<>();

        Date minimumTime = DateUtils.addMinutes(timeFormat.parse(beginningTime), 15);
        Date maximumTime = DateUtils.addMinutes(timeFormat.parse(beginningTime), 60);

        if (visitDate != null) {
            existedVisits = visitService.getByMedicalStaffAndVisitDate(Integer.parseInt(medicalStaff), visitDate);
            if (!existedVisits.isEmpty()) {
                for (Visit visit : existedVisits) {
                    if((visit.getBeginningTime().after(minimumTime) || visit.getBeginningTime().equals(minimumTime))
                            && (visit.getBeginningTime().before(maximumTime) || visit.getBeginningTime().equals(maximumTime))) {
                        maximumTime = visit.getBeginningTime();
                    }
                }
            }
        }

        if (maximumTime.after(timeFormat.parse("16:00"))) {
            maximumTime = timeFormat.parse("16:00");
        }

        existedTimes.add(timeFormat.format(minimumTime));
        existedTimes.add(timeFormat.format(maximumTime));

        return existedTimes;
    }

    @RequestMapping(value = "/patient-details/{patientId}/new-visit", method = RequestMethod.POST)
    public String newVisit(@ModelAttribute("visit") Visit visit, @PathVariable("patientId") int patientId,
                           @ModelAttribute("medicalStaffId") int medicalStaffId) {
        visit.setMedicalStaff(medicalStaffService.getById(medicalStaffId));
        visit.setPatient(patientService.getById(patientId));
        visitService.add(visit);

        return "redirect:/patient-details/{patientId}";
    }

    @RequestMapping(value = "/patient", method = RequestMethod.POST)
    public String addPatient(@ModelAttribute("patient") @Valid Patient patient, BindingResult result, Model model) {
        int id = patient.getId();
        model.addAttribute("id", id);

        if (result.hasErrors()) {
            return "patient";
        }

        if (id == 0) {
            UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            patientService.addWithInitialMedicalCase(patient, userDetails.getUsername());
        } else {
            patientService.update(patient);
        }

        return "redirect:/patients";
    }

    @RequestMapping("/remove/{id}")
    public String removePatient(@PathVariable("id") int id) {
        patientService.remove(id);
        return "redirect:/patients";
    }

    @RequestMapping(value = "/patient/{id}", method = RequestMethod.GET)
    public String editPatient(@PathVariable("id") int id, Model model) {
        model.addAttribute("patient", patientService.getById(id));
        return "patient";
    }
}
