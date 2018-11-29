package ru.tsystems.medicalinstitute.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.tsystems.medicalinstitute.bo.Diagnosis;
import ru.tsystems.medicalinstitute.bo.MedicalCase;
import ru.tsystems.medicalinstitute.bo.PdfFile;
import ru.tsystems.medicalinstitute.service.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@Controller
public class MedicalCaseController {
    private final CaseStatusService caseStatusService;
    private final MedicalCaseService medicalCaseService;
    private final PatientService patientService;
    private final MedicalStaffService medicalStaffService;
    private final PdfFileService pdfFileService;
    private final DiagnosisService diagnosisService;
    private final MedicalProcedureService medicalProcedureService;

    public MedicalCaseController(final CaseStatusService caseStatusService, final MedicalCaseService medicalCaseService,
                                 final PatientService patientService, final MedicalStaffService medicalStaffService,
                                 final PdfFileService pdfFileService, final DiagnosisService diagnosisService,
                                 final MedicalProcedureService medicalProcedureService) {
        this.caseStatusService = caseStatusService;
        this.medicalCaseService = medicalCaseService;
        this.patientService = patientService;
        this.medicalStaffService = medicalStaffService;
        this.pdfFileService = pdfFileService;
        this.diagnosisService = diagnosisService;
        this.medicalProcedureService = medicalProcedureService;
    }

    @RequestMapping(value = "/patient-details/{patientId}/new-medical-case", method = RequestMethod.GET)
    public String newMedicalCase(@PathVariable("patientId") int patientId, Model model) {
        MedicalCase medicalCase = new MedicalCase();

        model.addAttribute("patient", patientService.getById(patientId));
        model.addAttribute("medicalStaff", medicalStaffService.listMedicalStaff());
        model.addAttribute("medicalCase", medicalCase);

        return "new-medical-case";
    }

    @RequestMapping(value = "/patient-details/{patientId}/new-medical-case", method = RequestMethod.POST)
    public String addMedicalCase(@PathVariable("patientId") int patientId, @ModelAttribute("medicalCase") MedicalCase medicalCase, @ModelAttribute("medicalStaffId") int medicalStaffId, Model model) {
        medicalCase.setBeginningDate(new Date());
        medicalCase.setCaseStatus(caseStatusService.getByName("OPENED"));
        medicalCase.setPatient(patientService.getById(patientId));
        medicalCase.setMedicalStaff(medicalStaffService.getById(medicalStaffId));

        medicalCaseService.add(medicalCase);

        return "redirect:/patient-details/{patientId}";
    }

    @RequestMapping(value = "/medical-cases", method = RequestMethod.GET)
    public String listMedicalCases(@RequestParam(required = false, defaultValue = "") String caseNumber,
                                   @RequestParam(required = false, defaultValue = "") String patientName,
                                   Model model) {
        model.addAttribute("medicalCases", medicalCaseService.filter(caseNumber, patientName));
        model.addAttribute("patientName", patientName);
        model.addAttribute("caseNumber", caseNumber);

        return "medical-cases";
    }

    @RequestMapping(value = "/medical-case/{id}", method = RequestMethod.GET)
    public String detailMedicalCase(@PathVariable("id") int id, Model model) {
        model.addAttribute("medicalCase", medicalCaseService.getById(id));
        model.addAttribute("pdfFiles", pdfFileService.getByMedicalCaseId(id));
        model.addAttribute("diagnoses", diagnosisService.getByMedicalCaseId(id));
        model.addAttribute("medicalProcedures", medicalProcedureService.getByMedicalCase(id));

        return "medical-case";
    }

    @RequestMapping(value = "/medical-case/{id}/change", method = RequestMethod.POST)
    public @ResponseBody
    Date changeMedicalCaseStatus(@PathVariable("id") int id, @RequestBody String status) {
        MedicalCase medicalCase = medicalCaseService.getById(id);

        medicalCase.setCaseStatus(caseStatusService.getByName(status));

        Date endingDate = new Date();
        medicalCase.setEndingDate(endingDate);

        medicalCaseService.update(medicalCase);

        return endingDate;
    }

    @RequestMapping(value = "/medical-case/{medicalCaseId}/diagnosis", method = RequestMethod.GET)
    public String addDiagnosis(@PathVariable("medicalCaseId") int caseId, Model model) {
        model.addAttribute("medicalCase", medicalCaseService.getById(caseId));

        Diagnosis diagnosis = new Diagnosis();
        model.addAttribute("diagnosis", diagnosis);

        return "diagnosis";
    }

    @RequestMapping(value = "/medical-case/{medicalCaseId}/diagnosis/{diagnosisId}", method = RequestMethod.GET)
    public String editDiagnosis(@PathVariable("medicalCaseId") int caseId, @PathVariable("diagnosisId") int diagnosisId, Model model) {
        model.addAttribute("diagnosis", diagnosisService.getById(diagnosisId));
        model.addAttribute("medicalCase", medicalCaseService.getById(caseId));

        return "diagnosis";
    }

    @RequestMapping(value = "/medical-case/{medicalCaseId}/diagnosis-details/{diagnosisId}", method = RequestMethod.GET)
    public String detailDiagnosis(@PathVariable("medicalCaseId") int caseId, @PathVariable("diagnosisId") int diagnosisId, Model model) {
        model.addAttribute("diagnosis", diagnosisService.getById(diagnosisId));
        model.addAttribute("medicalCase", medicalCaseService.getById(caseId));

        return "diagnosis-details";
    }

    @RequestMapping(value = "/medical-case/{medicalCaseId}/diagnosis", method = RequestMethod.POST)
    public String addPatient(@PathVariable("medicalCaseId") int medicalCaseId, @ModelAttribute("diagnosis") Diagnosis diagnosis, Model model) {
        if (diagnosis.getId() == 0) {
            UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            diagnosis.setMedicalStaff(medicalStaffService.findByEmail(userDetails.getUsername()));
            diagnosis.setMedicalCase(medicalCaseService.getById(medicalCaseId));
            diagnosis.setDiagnosisDate(new Date());

            diagnosisService.add(diagnosis);
        } else {
            diagnosisService.update(diagnosis);
        }

        return "redirect:/medical-case/{medicalCaseId}";
    }

    @RequestMapping(value = "/medical-case/{id}/upload", method = RequestMethod.POST)
    public String savePdfFile(@PathVariable("id") int id, @RequestParam("file") MultipartFile file) {
        if (file.getOriginalFilename() == null || file.getOriginalFilename().isEmpty()) {
            return "redirect:/medical-case/{id}";
        }

        try {
            PdfFile pdfFile = new PdfFile();
            pdfFile.setName(file.getOriginalFilename());
            pdfFile.setData(file.getBytes());
            pdfFile.setMedicalCase(medicalCaseService.getById(id));
            pdfFileService.add(pdfFile);
        } catch (IOException ex) {
            return "redirect:/medical-cases";
        }

        return "redirect:/medical-case/{id}";
    }

    @RequestMapping(value = "medical-case/{caseId}/pdf-file/{id}/delete")
    public String deletePdfFile(@PathVariable("caseId") int caseId, @PathVariable("id") int id) {
        pdfFileService.remove(id);

        return "redirect:/medical-case/{caseId}";
    }

    @RequestMapping(value = "medical-case/{caseId}/pdf-file/{id}/download")
    public String downloadPdfFile(@PathVariable("caseId") int caseId, @PathVariable("id") int id, HttpServletResponse response) {
        PdfFile pdfFile = pdfFileService.getById(id);
        try {
            response.setHeader("Content-Disposition", "attachment; filename=\"" + pdfFile.getName() + "\"");
            response.setContentLength(pdfFile.getData().length);
            FileCopyUtils.copy(pdfFile.getData(), response.getOutputStream());

        } catch (IOException e) {
            return "redirect:/medical-case/{caseId}";
        }

        return "redirect:/medical-case/{caseId}";
    }
}
