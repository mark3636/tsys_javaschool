package ru.tsystems.medicalinstitute.service;

import ru.tsystems.medicalinstitute.bo.PdfFile;

import java.util.List;

public interface PdfFileService extends AbstractService<PdfFile> {
    /**
     * Returns pdf files by their medical case
     * @param id medical case id
     * @return List of pdf files
     */
    List<PdfFile> getByMedicalCaseId(int id);
}
