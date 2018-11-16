package ru.tsystems.medicalinstitute.service.impl;

import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.tsystems.medicalinstitute.bo.PdfFile;
import ru.tsystems.medicalinstitute.dao.PdfFileDAO;
import ru.tsystems.medicalinstitute.mappers.PdfFileMapper;
import ru.tsystems.medicalinstitute.service.PdfFileService;

import java.util.List;

@Service
@Transactional
public class PdfFileServiceImpl implements PdfFileService {
    private final PdfFileDAO pdfFileDAO;
    private PdfFileMapper mapper = Mappers.getMapper(PdfFileMapper.class);

    public PdfFileServiceImpl(final PdfFileDAO pdfFileDAO) {
        this.pdfFileDAO = pdfFileDAO;
    }

    @Override
    public void add(PdfFile bo) {
        pdfFileDAO.add(mapper.fromBo(bo));
    }

    @Override
    public void update(PdfFile bo) {
        pdfFileDAO.update(mapper.fromBo(bo));
    }

    @Override
    public PdfFile getById(int id) {
        return mapper.toBo(pdfFileDAO.getById(id));
    }

    @Override
    public void remove(int id) {
        pdfFileDAO.remove(id);
    }

    @Override
    public List<PdfFile> getByMedicalCaseId(int id) {
        return mapper.toBos(pdfFileDAO.getByMedicalCaseId(id));
    }
}
