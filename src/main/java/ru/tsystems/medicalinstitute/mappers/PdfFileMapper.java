package ru.tsystems.medicalinstitute.mappers;

import org.mapstruct.Mapper;
import ru.tsystems.medicalinstitute.bo.PdfFile;
import ru.tsystems.medicalinstitute.model.PdfFileEntity;

import java.util.List;

@Mapper(uses = {MedicalCaseMapper.class})
public interface PdfFileMapper {
    PdfFile toBo(PdfFileEntity pdfFileEntity);
    PdfFileEntity fromBo(PdfFile pdfFile);
    List<PdfFile> toBos(List<PdfFileEntity> pdfFileEntities);
}
