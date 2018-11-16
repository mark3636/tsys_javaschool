package ru.tsystems.medicalinstitute.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.tsystems.medicalinstitute.bo.MedicalStaff;
import ru.tsystems.medicalinstitute.service.MedicalStaffService;

import javax.validation.Valid;

@Controller
public class LoginController {
    private final MedicalStaffService medicalStaffService;

    public LoginController(final MedicalStaffService medicalStaffService) {
        this.medicalStaffService = medicalStaffService;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(@RequestParam(value = "error", required = false) String error, Model model) {
        if(error != null) {
            model.addAttribute("error", "Wrong email or password");
        }
        return "login";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String showRegistrationForm(Model model) {
        MedicalStaff medicalStaff = new MedicalStaff();
        model.addAttribute("medicalStaff", medicalStaff);

        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String register(@ModelAttribute("medicalStaff") @Valid MedicalStaff medicalStaff, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "registration";
        }

        //TODO: add email unique checking

        medicalStaffService.add(medicalStaff);

        return "login";
    }
}
