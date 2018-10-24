package ru.tsystems.medicalinstitute.bo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.Objects;

public class Visit {
    private int id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date visitDate;
    @DateTimeFormat(pattern = "HH:mm")
    private Date beginningTime;
    @DateTimeFormat(pattern = "HH:mm")
    private Date endingTime;
    private MedicalStaff medicalStaff;
    private Patient patient;

    public Visit() {
    }

    public Visit(int id, Date visitDate, Date beginningTime, Date endingTime, MedicalStaff medicalStaff, Patient patient) {
        this.id = id;
        this.visitDate = visitDate;
        this.beginningTime = beginningTime;
        this.endingTime = endingTime;
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
        return beginningTime;
    }
    public void setBeginningDate(Date beginningDate) {
        this.beginningTime = beginningDate;
    }

    public Date getVisitDate() {
        return visitDate;
    }
    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }

    public Date getBeginningTime() {
        return beginningTime;
    }
    public void setBeginningTime(Date beginningTime) {
        this.beginningTime = beginningTime;
    }

    public Date getEndingTime() {
        return endingTime;
    }
    public void setEndingTime(Date endingTime) {
        this.endingTime = endingTime;
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
}
