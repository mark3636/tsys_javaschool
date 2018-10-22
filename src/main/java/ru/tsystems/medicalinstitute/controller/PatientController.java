package ru.tsystems.medicalinstitute.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.tsystems.medicalinstitute.bo.MedicalCase;
import ru.tsystems.medicalinstitute.bo.Patient;
import ru.tsystems.medicalinstitute.bo.Visit;
import ru.tsystems.medicalinstitute.service.MedicalCaseService;
import ru.tsystems.medicalinstitute.service.PatientService;
import ru.tsystems.medicalinstitute.service.VisitService;
import ru.tsystems.medicalinstitute.validators.PatientValidator;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class PatientController {
    private final static String OPENED = "OPENED";
    private final static String CLOSED = "CLOSED";
    private final static String COMPLETED = "COMPLETED";

    @Autowired
    private PatientService patientService;
    @Autowired
    private MedicalCaseService medicalCaseService;
    @Autowired
    private VisitService visitService;
    @Autowired
    private PatientValidator validator;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homePage(Model model) {
        return "redirect:/patients";
    }

    @RequestMapping(value = "/patients", method = RequestMethod.GET)
    public String listPatients(@RequestParam(required = false, defaultValue = "") String surname,
                               @RequestParam(required = false, defaultValue = "") String birthday,
                               @RequestParam(required = false, defaultValue = "") String caseNumber, Model model) throws ParseException {
        List<Patient> patients = patientService.listPatients();

        if (surname != null && !surname.isEmpty()) {
            patients = patients.stream()
                    .filter(patient -> patient.getSurname().contains(surname)).collect(Collectors.toList());
            ;
        }

        if (birthday != null && !birthday.isEmpty()) {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
            patients = patients.stream()
                    .filter(patient -> patient.getBirthday().equals(date)).collect(Collectors.toList());;
        }

        List<MedicalCase> medicalCases = medicalCaseService.listMedicalCases();

        if (caseNumber != null && !caseNumber.isEmpty()) {
            medicalCases = medicalCases.stream()
                    .filter(medicalCase -> medicalCase.getNumber().contains(caseNumber)).collect(Collectors.toList());

            if (medicalCases.isEmpty()) {
                patients = new ArrayList<>();
            }

            for (MedicalCase medicalCase : medicalCases) {
                patients = patients.stream()
                        .filter(patient -> patient.getId() == medicalCase.getPatient().getId()).collect(Collectors.toList());;
            }
        }

        model.addAttribute("surname", surname);
        model.addAttribute("birthday", birthday);
        model.addAttribute("caseNumber", caseNumber);
        model.addAttribute("listPatients", patients);
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
        List<MedicalCase> medicalCases = medicalCaseService.getByPatientId(id);
        model.addAttribute("medicalCases", medicalCases);
        String patientStatus = "Undefined";

        if (!medicalCases.isEmpty()) {
            patientStatus = "Discharged";

            for (MedicalCase medicalCase : medicalCases) {
                if (medicalCase.getCaseStatus().getName().equals(OPENED)) {
                    patientStatus = "On treatment";
                    break;
                }
            }
        }
        model.addAttribute("patientStatus", patientStatus);

        return "patient-details";
    }

    @RequestMapping(value = "/patient-details/{patientId}/new-visit", method = RequestMethod.GET)
    public String newVisit(@PathVariable("patientId") int id, Model model) {
        model.addAttribute("patient", patientService.getById(id));
        return "visit";
    }

    @RequestMapping(value = "/new-visit", method = RequestMethod.POST)
    public String newVisit(@ModelAttribute("visit") @Validated Visit visit, Model model) {
        visitService.add(visit);
        int patientId = visit.getPatient().getId();
        return "redirect:/patient-details/{patientId}";
    }

    @RequestMapping(value = "/patient", method = RequestMethod.POST)
    public String addPatient(@ModelAttribute("patient") @Validated Patient patient, BindingResult result, Model model) {
        validator.validate(patient, result);

        int id = patient.getId();
        model.addAttribute("id", id);

        if (result.hasErrors()) {
            if (id == 0) {
                return "patient";
            } else {
                return "redirect:/patient/{id}";
            }
        }

        if (id == 0) {
            patientService.add(patient);
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
