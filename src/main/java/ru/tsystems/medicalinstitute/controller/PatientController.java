package ru.tsystems.medicalinstitute.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.tsystems.medicalinstitute.bo.Patient;
import ru.tsystems.medicalinstitute.mapper.PatientMapper;
import ru.tsystems.medicalinstitute.model.PatientEntity;
import ru.tsystems.medicalinstitute.service.PatientService;

@Controller
public class PatientController {
    private PatientService patientService;

    @Autowired
    public void setPatientService(PatientService patientService) {
        this.patientService = patientService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homePage(Model model) {
        return "redirect:/patients";
    }

    @RequestMapping(value = "/patients", method = RequestMethod.GET)
    public String listPatients(Model model) {
        model.addAttribute("listPatients", this.patientService.listPatients());
        return "patients";
    }

    @RequestMapping(value = "/patient", method = RequestMethod.GET)
    public String addPatient(Model model) {
        return "patient";
    }

    @RequestMapping(value = "/patient-details/{id}", method = RequestMethod.GET)
    public String detailPatient(@PathVariable("id") int id, Model model) {
        model.addAttribute("patient", patientService.getPatientById(id));
        return "patient-details";
    }

    @RequestMapping(value= "/patient", method = RequestMethod.POST)
    public String addPatient(@ModelAttribute("patient") Patient patient){
        if(patient.getId() == 0){
            this.patientService.addPatient(patient);
        }else{
            this.patientService.updatePatient(patient);
        }

        return "redirect:/patients";
    }

    @RequestMapping("/remove/{id}")
    public String removePatient(@PathVariable("id") int id){
        this.patientService.removePatient(id);
        return "redirect:/patients";
    }

    @RequestMapping(value = "/patient/{id}", method = RequestMethod.GET)
    public String editPatient(@PathVariable("id") int id, Model model){
        model.addAttribute("patient", patientService.getPatientById(id));
        return "patient";
    }
}
