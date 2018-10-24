package ru.tsystems.medicalinstitute.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.tsystems.medicalinstitute.bo.MedicalStaff;
import ru.tsystems.medicalinstitute.service.MedicalStaffService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class LoginController {
    @Autowired
    MedicalStaffService medicalStaffService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(@RequestParam(value = "error", required = false) String error) {
        return "login";
    }
//
//    @RequestMapping(value = "/logout", method = RequestMethod.POST)
//    public String logout(HttpServletRequest request, HttpServletResponse response) throws ParseException {
//        Authentication auth = SecurityContextHolder.getContext()
//                .getAuthentication();
//        if (auth != null) {
//            new SecurityContextLogoutHandler().logout(request, response, auth);
//            request.getSession().invalidate();
//        }
//
//        MedicalStaff medicalStaff = new MedicalStaff();
//        medicalStaff.setName("Maria");
//        medicalStaff.setSurname("Hirurgova");
//        medicalStaff.setEmail("hirurg@mail.ru");
//        medicalStaff.setPassword("hirurg");
//        medicalStaff.setBirthday(new SimpleDateFormat().parse("1997-12-05"));
//        medicalStaffService.add(medicalStaff);
//
//        return "/login";
//    }
}
