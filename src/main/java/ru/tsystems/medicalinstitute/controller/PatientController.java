package ru.tsystems.medicalinstitute.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
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

    private final Logger logger = LoggerFactory.getLogger(PatientController.class);

    public PatientController(final PatientService patientService, final MedicalCaseService medicalCaseService,
                             final VisitService visitService) {
        this.patientService = patientService;
        this.medicalCaseService = medicalCaseService;
        this.visitService = visitService;
    }

    @RequestMapping(value = "/patients", method = RequestMethod.GET)
    public String listPatients(@RequestParam(required = false, defaultValue = "") String surname,
                               @RequestParam(required = false, defaultValue = "") String birthday,
                               @RequestParam(required = false, defaultValue = "") String caseNumber,
                               Model model) throws ParseException {

        model.addAttribute("surname", surname);
        model.addAttribute("birthday", birthday);
        model.addAttribute("caseNumber", caseNumber);
        model.addAttribute("listPatients", patientService.filterPatients(surname.toLowerCase(),
                birthday, caseNumber.toLowerCase()));

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
    public String addPatient(Authentication authentication, @ModelAttribute("patient") @Valid Patient patient,
                             BindingResult result, Model model) {
        int id = patient.getId();
        model.addAttribute("id", id);

        if (result.hasErrors()) {
            return "patient";
        }

        if (id == 0) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            patientService.addWithInitialMedicalCase(patient, userDetails.getUsername());
            logger.info("New patient with SSN {} was created", patient.getSocialSecurityNumber());
        } else {
            patientService.update(patient);
            logger.info("Patient with SSN {} was updated", patient.getSocialSecurityNumber());
        }

        return "redirect:/patients";
    }

    @RequestMapping(value = "/patient/{id}/delete", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void removePatient(@PathVariable("id") int id) {
        patientService.remove(id);
        logger.info("Patient with id {} was deleted", id);
    }

    @RequestMapping(value = "/patient/{id}", method = RequestMethod.GET)
    public String editPatient(@PathVariable("id") int id, Model model) {
        model.addAttribute("patient", patientService.getById(id));

        return "patient";
    }
}
