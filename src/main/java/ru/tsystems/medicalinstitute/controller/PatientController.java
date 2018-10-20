package ru.tsystems.medicalinstitute.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.tsystems.medicalinstitute.bo.Patient;
import ru.tsystems.medicalinstitute.service.MedicalCaseService;
import ru.tsystems.medicalinstitute.service.PatientService;

@Controller
public class PatientController {
    @Autowired
    private PatientService patientService;
    @Autowired
    private MedicalCaseService medicalCaseService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homePage(Model model) {
        return "redirect:/patients";
    }

    @RequestMapping(value = "/patients", method = RequestMethod.GET)
    public String listPatients(Model model) {
        model.addAttribute("listPatients", patientService.listPatients());
        return "patients";
    }

    @RequestMapping(value = "/patient", method = RequestMethod.GET)
    public String addPatient(Model model) {
        return "patient";
    }

    @RequestMapping(value = "/patient-details/{id}", method = RequestMethod.GET)
    public String detailPatient(@PathVariable("id") int id, Model model) {
        model.addAttribute("patient", patientService.getById(id));
        model.addAttribute("medicalCases", medicalCaseService.getByPatientId(id));
        return "patient-details";
    }

    @RequestMapping(value= "/patient", method = RequestMethod.POST)
    public String addPatient(@ModelAttribute("patient") @Validated Patient patient){
        if(patient.getId() == 0){
            patientService.add(patient);
        }else{
            patientService.update(patient);
        }

        return "redirect:/patients";
    }

    @RequestMapping("/remove/{id}")
    public String removePatient(@PathVariable("id") int id){
        patientService.remove(id);
        return "redirect:/patients";
    }

    @RequestMapping(value = "/patient/{id}", method = RequestMethod.GET)
    public String editPatient(@PathVariable("id") int id, Model model){
        model.addAttribute("patient", patientService.getById(id));
        return "patient";
    }
}
