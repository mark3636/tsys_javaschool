package ru.tsystems.medicalinstitute.dao;

import ru.tsystems.medicalinstitute.model.PdfFileEntity;

import java.util.List;

public interface PdfFileDAO extends AbstractDAO<PdfFileEntity> {
    List<PdfFileEntity> listPdfFiles();
    List<PdfFileEntity> getByMedicalCaseId(int id);
}
