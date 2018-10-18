package ru.tsystems.medicalinstitute.mapper;

import ru.tsystems.medicalinstitute.bo.MedicalCase;
import ru.tsystems.medicalinstitute.bo.PdfFile;
import ru.tsystems.medicalinstitute.model.PdfFileEntity;

import java.util.HashSet;
import java.util.Set;

public class PdfFileMapper {
    public static PdfFile toBo(PdfFileEntity pdfFileEntity) {
        return new PdfFile(pdfFileEntity.getId(), pdfFileEntity.getName(), pdfFileEntity.getData(), MedicalCaseMapper.toBo(pdfFileEntity.getMedicalCase()));
    }

    public static Set<PdfFile> toBo(Set<PdfFileEntity> entities) {
        Set<PdfFile> set = new HashSet<>();
        for(PdfFileEntity entity : entities) {
            set.add(toBo(entity));
        }
        return set;
    }
}
