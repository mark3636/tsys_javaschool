package ru.tsystems.medicalinstitute.controller;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.tsystems.medicalinstitute.bo.MedicalStaff;
import ru.tsystems.medicalinstitute.bo.Role;
import ru.tsystems.medicalinstitute.service.MedicalStaffService;
import ru.tsystems.medicalinstitute.service.RoleService;

import javax.validation.Valid;
import java.util.Collection;

@Controller
public class LoginController {
    private final MedicalStaffService medicalStaffService;
    private final RoleService roleService;

    public LoginController(final MedicalStaffService medicalStaffService,
                           final RoleService roleService) {
        this.medicalStaffService = medicalStaffService;
        this.roleService = roleService;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(@RequestParam(value = "error", required = false) String error, Model model) {
        if (error != null) {
            model.addAttribute("error", "Wrong email or password");
        }
        return "login";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String showRegistrationForm(@RequestParam(value = "error", required = false) String error, Model model) {
        MedicalStaff medicalStaff = new MedicalStaff();
        model.addAttribute("medicalStaff", medicalStaff);
        model.addAttribute("roles", roleService.listRoles());
        model.addAttribute("roleId", "");

        if (error != null) {
            model.addAttribute("error", "User with such email already exists");
        }

        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String register(
            @ModelAttribute("medicalStaff") MedicalStaff medicalStaff,
            @ModelAttribute("roleId") int roleId,
            BindingResult result, Model model) {
        if (result.hasErrors()) {
            medicalStaff.setPassword(null);
            return "registration";
        }

        if (medicalStaffService.findByEmail(medicalStaff.getEmail()) != null) {
            model.addAttribute("error", "User with such email already exists");
            medicalStaff.setPassword(null);
            return "registration";
        }

        medicalStaff.setRole(roleService.getById(roleId));
        medicalStaffService.add(medicalStaff);

        return "login";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homePage() {
        Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();

        for (GrantedAuthority auth : authorities) {
            if (auth.getAuthority().equals("ROLE_NURSE")) {
                return "redirect:/medical-procedures";
            }
        }

        return "redirect:/patients";
    }
}
