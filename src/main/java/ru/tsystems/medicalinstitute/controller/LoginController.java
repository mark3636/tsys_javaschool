package ru.tsystems.medicalinstitute.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.tsystems.medicalinstitute.service.MedicalStaffService;

@Controller
public class LoginController {
    @Autowired
    MedicalStaffService medicalStaffService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(@RequestParam(value = "error", required = false) String error) {
        return "login";
    }
}
