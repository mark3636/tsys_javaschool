package ru.tsystems.medicalinstitute.service;

import ru.tsystems.medicalinstitute.bo.PdfFile;

import java.util.List;

public interface PdfFileService extends AbstractService<PdfFile> {
    List<PdfFile> getByMedicalCaseId(int id);
}
