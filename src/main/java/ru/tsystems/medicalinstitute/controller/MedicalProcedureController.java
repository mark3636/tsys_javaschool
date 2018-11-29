package ru.tsystems.medicalinstitute.controller;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.tsystems.medicalinstitute.bo.MedicalProcedure;
import ru.tsystems.medicalinstitute.bo.ProcedureCommentForm;
import ru.tsystems.medicalinstitute.service.MedicalCaseService;
import ru.tsystems.medicalinstitute.service.MedicalProcedureService;
import ru.tsystems.medicalinstitute.service.MedicalStaffService;
import ru.tsystems.medicalinstitute.service.ProcedureStatusService;

import java.util.Date;

@Controller
public class MedicalProcedureController {
    private final MedicalProcedureService medicalProcedureService;
    private final MedicalCaseService medicalCaseService;
    private final MedicalStaffService medicalStaffService;
    private final ProcedureStatusService procedureStatusService;

    public MedicalProcedureController(final MedicalProcedureService medicalProcedureService,
                                      final MedicalCaseService medicalCaseService,
                                      final MedicalStaffService medicalStaffService,
                                      final ProcedureStatusService procedureStatusService) {
        this.medicalProcedureService = medicalProcedureService;
        this.medicalCaseService = medicalCaseService;
        this.medicalStaffService = medicalStaffService;
        this.procedureStatusService = procedureStatusService;
    }

    @RequestMapping(value = "/medical-procedures", method = RequestMethod.GET)
    public String listPatients(@RequestParam(required = false, defaultValue = "") String patientName,
                               @RequestParam(required = false, defaultValue = "") String socialSecurityNumber,
                               @RequestParam(required = false, defaultValue = "") String caseNumber,
                               Model model) {

        model.addAttribute("patientName", patientName);
        model.addAttribute("birthday", socialSecurityNumber);
        model.addAttribute("caseNumber", caseNumber);
        model.addAttribute("medicalProcedures", medicalProcedureService.filter(patientName,
                socialSecurityNumber.isEmpty() ? null : Integer.parseInt(socialSecurityNumber), caseNumber));

        return "medical-procedures";
    }

    @RequestMapping(value = "/procedure-details/{medicalProcedureId}", method = RequestMethod.GET)
    public String detailProcedure(@PathVariable(value = "medicalProcedureId") int medicalProcedureId, Model model) {
        model.addAttribute("medicalProcedure", medicalProcedureService.getById(medicalProcedureId));

        return "procedure-details";
    }

    @RequestMapping(value = "/medical-case/{medicalCaseId}/medical-procedure", method = RequestMethod.GET)
    public String addMedicalProcedure(@PathVariable(value = "medicalCaseId") int medicalCaseId, Model model) {
        MedicalProcedure medicalProcedure = new MedicalProcedure();
        model.addAttribute("medicalCase", medicalCaseService.getById(medicalCaseId));
        model.addAttribute("medicalProcedure", medicalProcedure);

        return "medical-procedure";
    }

    @RequestMapping(value = "/medical-case/{medicalCaseId}/medical-procedure/{medicalProcedureId}", method = RequestMethod.GET)
    public String editMedicalProcedure(@PathVariable("medicalCaseId") int caseId,
                                       @PathVariable("medicalProcedureId") int medicalProcedureId, Model model) {
        model.addAttribute("medicalProcedure", medicalProcedureService.getById(medicalProcedureId));
        model.addAttribute("medicalCase", medicalCaseService.getById(caseId));

        return "medical-procedure";
    }

    @RequestMapping(value = "/medical-case/{medicalCaseId}/medical-procedure", method = RequestMethod.POST)
    public String addPatient(@PathVariable("medicalCaseId") int medicalCaseId,
                             @ModelAttribute("medicalProcedure") MedicalProcedure medicalProcedure, Model model) {
        if (medicalProcedure.getId() == 0) {
            medicalProcedure.setMedicalCase(medicalCaseService.getById(medicalCaseId));
            medicalProcedure.setProcedureStatus(procedureStatusService.getByName("NEW"));

            medicalProcedureService.add(medicalProcedure);
        } else {
            medicalProcedureService.update(medicalProcedure);
        }

        return "redirect:/medical-case/{medicalCaseId}";
    }

    @RequestMapping(value = "/medical-procedure/{id}/change", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void changeProcedureStatus(@PathVariable("id") int id,
                                      @RequestBody ProcedureCommentForm procedureCommentForm) {
        MedicalProcedure medicalProcedure = medicalProcedureService.getById(id);
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        medicalProcedure.setMedicalStaff(medicalStaffService.findByEmail(userDetails.getUsername()));
        medicalProcedure.setProcedureDate(new Date());
        medicalProcedure.setProcedureStatus(procedureStatusService.getByName(procedureCommentForm.getStatus()));
        medicalProcedure.setComment(procedureCommentForm.getComment());

        medicalProcedureService.update(medicalProcedure);
    }
}
