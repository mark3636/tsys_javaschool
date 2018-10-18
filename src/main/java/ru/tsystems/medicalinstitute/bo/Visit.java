package ru.tsystems.medicalinstitute.bo;

import java.util.Date;

public class Visit {
    private int id;
    private Date beginningDate;
    private Date endingDate;
    private MedicalCase medicalCase;
    private MedicalStaff medicalStaff;

    public Visit() {
    }

    public Visit(int id, Date beginningDate, Date endingDate, MedicalCase medicalCase, MedicalStaff medicalStaff, Patient patient) {
        this.id = id;
        this.beginningDate = beginningDate;
        this.endingDate = endingDate;
        this.medicalCase = medicalCase;
        this.medicalStaff = medicalStaff;
        this.patient = patient;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getBeginningDate() {
        return beginningDate;
    }

    public void setBeginningDate(Date beginningDate) {
        this.beginningDate = beginningDate;
    }

    public Date getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(Date endingDate) {
        this.endingDate = endingDate;
    }

    public MedicalCase getMedicalCase() {
        return medicalCase;
    }

    public void setMedicalCase(MedicalCase medicalCase) {
        this.medicalCase = medicalCase;
    }

    public MedicalStaff getMedicalStaff() {
        return medicalStaff;
    }

    public void setMedicalStaff(MedicalStaff medicalStaff) {
        this.medicalStaff = medicalStaff;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    private Patient patient;
}
