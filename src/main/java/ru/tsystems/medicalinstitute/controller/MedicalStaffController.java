package ru.tsystems.medicalinstitute.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.tsystems.medicalinstitute.service.MedicalStaffService;

@Controller
public class MedicalStaffController {
    @Autowired
    MedicalStaffService medicalStaffService;

    @RequestMapping(value = "/medical-staff", method = RequestMethod.GET)
    public String listMedicalStaff(Model model) {
        model.addAttribute("listMedicalStaff", medicalStaffService.listMedicalStaff());
        return "medical-staff";
    }
}
