package ru.tsystems.medicalinstitute.dao.impl;

import org.hibernate.query.Query;
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

    @SuppressWarnings("unchecked")
    @Override
    public List<PdfFileEntity> getByMedicalCaseId(int id) {
        Query query = getSession().createQuery("from PdfFileEntity where medicalCase.id = :medicalCaseId");
        query.setParameter("medicalCaseId", id);
        return query.list();
    }
}
