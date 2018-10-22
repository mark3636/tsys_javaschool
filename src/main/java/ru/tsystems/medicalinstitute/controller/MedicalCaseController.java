package ru.tsystems.medicalinstitute.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.tsystems.medicalinstitute.bo.Diagnosis;
import ru.tsystems.medicalinstitute.bo.PdfFile;
import ru.tsystems.medicalinstitute.service.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@Controller
public class MedicalCaseController {
    @Autowired
    MedicalCaseService medicalCaseService;
    @Autowired
    PatientService patientService;
    @Autowired
    MedicalStaffService medicalStaffService;
    @Autowired
    PdfFileService pdfFileService;
    @Autowired
    DiagnosisService diagnosisService;

    @RequestMapping(value = "/patient-details/{patientId}/add-case/", method = RequestMethod.GET)
    public String addMedicalCase(@PathVariable("patientId") int patientId, Model model) {
        model.addAttribute("patient", patientService.getById(patientId));
        return "medical-case";
    }

    @RequestMapping(value = "/medical-cases", method = RequestMethod.GET)
    public String listMedicalCases(Model model) {
        model.addAttribute("medicalCases", medicalCaseService.listMedicalCases());

        return "medical-cases";
    }

    @RequestMapping(value = "/medical-case/{id}", method = RequestMethod.GET)
    public String detailMedicalCase(@PathVariable("id") int id, Model model) {
        model.addAttribute("medicalCase", medicalCaseService.getById(id));
        model.addAttribute("pdfFiles", pdfFileService.getByMedicalCaseId(id));
        model.addAttribute("diagnoses", diagnosisService.getByMedicalCaseId(id));
        return "medical-case";
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

    @RequestMapping(value = "/medical-case/{medicalCaseId}/diagnosis", method = RequestMethod.POST)
    public String addPatient(@PathVariable("medicalCaseId") int medicalCaseId, @ModelAttribute("diagnosis") Diagnosis diagnosis,  Model model) {
//
//        int id = patient.getId();
//        model.addAttribute("id", id);
//
//        if (result.hasErrors()) {
//            if (id == 0) {
//                return "patient";
//            } else {
//                return "redirect:/patient/{id}";
//            }
//        }

        diagnosis.setMedicalCase(medicalCaseService.getById(medicalCaseId));
        diagnosis.setDiagnosisDate(new Date());
        diagnosis.setMedicalStaff(medicalStaffService.listMedicalStaff().get(0));

        if (diagnosis.getId() == 0) {
            diagnosisService.add(diagnosis);
        } else {
            diagnosisService.update(diagnosis);
        }

        return "redirect:/medical-case/{medicalCaseId}";
    }

    @RequestMapping(value = "/medical-case/{id}/upload", method = RequestMethod.POST)
    public String savePdfFile(@PathVariable("id") int id, @RequestParam("file") MultipartFile file) {
        try {
            PdfFile pdfFile = new PdfFile();
            pdfFile.setName(file.getOriginalFilename());
            pdfFile.setData(file.getBytes());
            pdfFile.setMedicalCase(medicalCaseService.getById(id));
            pdfFileService.add(pdfFile);
        }
        catch (IOException ex) {
            return "redirect:/medical-cases";
        }

        return "redirect:/medical-case/{id}";
    }

    @RequestMapping(value = "medical-case/{caseId}/pdf-file/{id}/delete")
    public String deletePdfFile(@PathVariable("caseId") int caseId, @PathVariable("id") int id) {
        pdfFileService.remove(id);
        //return "redirect:/medical-case/{caseId}";
        return null;
    }

    @RequestMapping(value = "medical-case/{caseId}/pdf-file/{id}/download")
    public String downloadPdfFile(@PathVariable("caseId") int caseId, @PathVariable("id") int id, HttpServletResponse response) {
        PdfFile pdfFile = pdfFileService.getById(id);
        try {
            response.setHeader("Content-Disposition", "attachment; filename=\"" + pdfFile.getName() + "\"");
            response.setContentLength(pdfFile.getData().length);
            FileCopyUtils.copy(pdfFile.getData(), response.getOutputStream());

        } catch (IOException e) {}

        return null;
    }
}
