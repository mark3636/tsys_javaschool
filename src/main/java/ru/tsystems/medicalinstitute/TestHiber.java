package ru.tsystems.medicalinstitute;

import org.hibernate.Session;
import ru.tsystems.medicalinstitute.model.CaseStatusEntity;
import ru.tsystems.medicalinstitute.model.PatientEntity;
import ru.tsystems.medicalinstitute.model.PdfFileEntity;
import ru.tsystems.medicalinstitute.utils.HibernateUtil;

import java.sql.Date;
import java.time.LocalDate;


public class TestHiber {
    public static void main(String[] args) {
        System.out.println("Hibernate tutorial");

        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();

        PatientEntity patient = new PatientEntity();
        patient.setEmail("mark2@mail.ru");
        patient.setPhoneNumber("89325553535");
        patient.setAddress("1");
        patient.setBirthday(new java.util.Date());
        patient.setName("1");
        patient.setSurname("1");
        patient.setSocialSecurityNumber(223456780);
        patient.setPassportDetails("4");

        PdfFileEntity pdfFile = new PdfFileEntity();
        pdfFile.setData(new byte[]{1, 2, 3});
        pdfFile.setName("1");
        pdfFile.setPatient(patient);

        try {
            session.save(patient);
            session.save(pdfFile);
            session.getTransaction().commit();

            session.close();
        }
        finally {
            HibernateUtil.shutdown();
        }
    }
}
