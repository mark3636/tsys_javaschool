package ru.tsystems.medicalinstitute.bo;


import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Objects;

public class MedicalCase {
    private int id;
    @NotEmpty(message = "Number cannot be empty")
    @Size(min = 10, max = 10, message = "Name length should be equal to 10")
    private String number;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date beginningDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endingDate;
    private CaseStatus caseStatus;
    private Patient patient;
    private MedicalStaff medicalStaff;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MedicalCase that = (MedicalCase) o;
        return id == that.id &&
                Objects.equals(number, that.number) &&
                Objects.equals(beginningDate, that.beginningDate) &&
                Objects.equals(endingDate, that.endingDate) &&
                Objects.equals(caseStatus, that.caseStatus) &&
                Objects.equals(patient, that.patient) &&
                Objects.equals(medicalStaff, that.medicalStaff);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number, beginningDate, endingDate, caseStatus, patient, medicalStaff);
    }

    public MedicalCase() {
    }

    public MedicalCase(int id, String number, Date beginningDate, Date endingDate, CaseStatus caseStatus, Patient patient, MedicalStaff medicalStaff) {
        this.id = id;
        this.number = number;
        this.beginningDate = beginningDate;
        this.endingDate = endingDate;
        this.caseStatus = caseStatus;
        this.patient = patient;
        this.medicalStaff = medicalStaff;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
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

    public CaseStatus getCaseStatus() {
        return caseStatus;
    }
    public void setCaseStatus(CaseStatus caseStatus) {
        this.caseStatus = caseStatus;
    }

    public Patient getPatient() {
        return patient;
    }
    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public MedicalStaff getMedicalStaff() {
        return medicalStaff;
    }
    public void setMedicalStaff(MedicalStaff medicalStaff) {
        this.medicalStaff = medicalStaff;
    }


}
