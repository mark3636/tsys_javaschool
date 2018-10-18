package ru.tsystems.medicalinstitute.dao.impl;

import org.springframework.stereotype.Repository;
import ru.tsystems.medicalinstitute.dao.PdfFileDAO;
import ru.tsystems.medicalinstitute.model.PdfFileEntity;

import java.util.List;

@Repository
public class PdfFileDAOImpl extends AbstractDAOImpl<PdfFileEntity> implements PdfFileDAO {
    @SuppressWarnings("unchecked")
    @Override
    public List<PdfFileEntity> listPdfFiles() {
        return getSession().createQuery("from PdfFileEntity").list();
    }
}
