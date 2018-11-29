package ru.tsystems.medicalinstitute.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.tsystems.medicalinstitute.service.MedicalStaffService;

@Controller
public class MedicalStaffController {
    private final MedicalStaffService medicalStaffService;

    public MedicalStaffController(final MedicalStaffService medicalStaffService) {
        this.medicalStaffService = medicalStaffService;
    }

    @RequestMapping(value = "/medical-staff", method = RequestMethod.GET)
    public String listMedicalStaff(Model model) {
        model.addAttribute("listMedicalStaff", medicalStaffService.listMedicalStaff());

        return "medical-staff";
    }
}
