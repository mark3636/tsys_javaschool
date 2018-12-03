package ru.tsystems.medicalinstitute.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.tsystems.medicalinstitute.bo.Visit;
import ru.tsystems.medicalinstitute.service.MedicalStaffService;
import ru.tsystems.medicalinstitute.service.PatientService;
import ru.tsystems.medicalinstitute.service.VisitService;

import java.text.ParseException;
import java.util.List;

@Controller
public class VisitController {
    private final PatientService patientService;
    private final VisitService visitService;
    private final MedicalStaffService medicalStaffService;

    private final Logger logger = LoggerFactory.getLogger(LoginController.class);

    public VisitController(final PatientService patientService, final VisitService visitService,
                           final MedicalStaffService medicalStaffService) {
        this.patientService = patientService;
        this.visitService = visitService;
        this.medicalStaffService = medicalStaffService;
    }

    @RequestMapping(value = "/patient-details/{patientId}/new-visit", method = RequestMethod.GET)
    public String newVisit(@PathVariable("patientId") int id, Model model) {
        model.addAttribute("patient", patientService.getById(id));
        model.addAttribute("visits", visitService.listVisits());
        model.addAttribute("medicalStaff", medicalStaffService.getByPosition("DOCTOR"));
        model.addAttribute("medicalStaffId", "");

        return "visit";
    }

    @RequestMapping(value = "/patient-details/{patientId}/new-visit-beginning-time", method = RequestMethod.GET)
    public @ResponseBody
    List<String> getExistedTime(
            @RequestParam(value = "medicalStaff", required = false) String medicalStaff,
            @RequestParam(value = "visitDate", required = false) String visitDate) {
        try {
            return visitService.getExistedTime(Integer.parseInt(medicalStaff), visitDate);
        } catch (ParseException e) {
            logger.error("Can't parse medical staff id: {} or visit date: {}", medicalStaff, visitDate);
            logger.error("Exception: {}", e.getMessage());
            return null;
        }
    }

    @RequestMapping(value = "/patient-details/{patientId}/new-visit-ending-time", method = RequestMethod.GET)
    public @ResponseBody
    List<String> getEndingTime(
            @RequestParam(value = "medicalStaff", required = false) String medicalStaff,
            @RequestParam(value = "visitDate", required = false) String visitDate,
            @RequestParam(value = "beginningTime", required = false) String beginningTime) {
        try {
            return visitService.getEndingTime(Integer.parseInt(medicalStaff), visitDate, beginningTime);
        } catch (ParseException e) {
            logger.error("Can't parse medical staff id: {}, visit date: {} or beginning time: {}",
                    medicalStaff, visitDate, beginningTime);
            logger.error("Exception: {}", e.getMessage());
            return null;
        }
    }

    @RequestMapping(value = "/patient-details/{patientId}/new-visit", method = RequestMethod.POST)
    public String newVisit(@ModelAttribute("visit") Visit visit, @PathVariable("patientId") int patientId,
                           @ModelAttribute("medicalStaffId") int medicalStaffId) {
        visit.setMedicalStaff(medicalStaffService.getById(medicalStaffId));
        visit.setPatient(patientService.getById(patientId));
        visitService.add(visit);

        logger.info("New visit {} was added", visit);

        return "redirect:/patient-details/{patientId}";
    }
}
