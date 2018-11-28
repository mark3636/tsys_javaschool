package ru.tsystems.medicalinstitute.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.tsystems.medicalinstitute.bo.Patient;
import ru.tsystems.medicalinstitute.service.MedicalCaseService;
import ru.tsystems.medicalinstitute.service.PatientService;
import ru.tsystems.medicalinstitute.service.VisitService;

import javax.validation.Valid;
import java.text.ParseException;

@Controller
public class PatientController {
    private final PatientService patientService;
    private final MedicalCaseService medicalCaseService;
    private final VisitService visitService;

    public PatientController(final PatientService patientService, final MedicalCaseService medicalCaseService,
                             final VisitService visitService) {
        this.patientService = patientService;
        this.medicalCaseService = medicalCaseService;
        this.visitService = visitService;
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
