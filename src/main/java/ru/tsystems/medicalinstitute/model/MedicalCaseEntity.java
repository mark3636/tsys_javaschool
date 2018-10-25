package ru.tsystems.medicalinstitute.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

/**
 * This entity represents medical case of particular patient.
 */
@Entity
@Table(name = "medical_case")
public class MedicalCaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "number", nullable = false, length = 10)
    private String number;
    @Column(name = "beginning_date")
    @Temporal(TemporalType.DATE)
    private Date beginningDate;
    @Column(name = "ending_date")
    @Temporal(TemporalType.DATE)
    private Date endingDate;
    @ManyToOne
    @JoinColumn(name = "id_status", nullable = false)
    private CaseStatusEntity caseStatus;
    @ManyToOne()
    @JoinColumn(name = "id_patient", nullable = false)
    private PatientEntity patient;
    @ManyToOne
    @JoinColumn(name = "id_medical_staff", nullable = false)
    private MedicalStaffEntity medicalStaff;

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

    public CaseStatusEntity getCaseStatus() {
        return caseStatus;
    }
    public void setCaseStatus(CaseStatusEntity caseStatus) {
        this.caseStatus = caseStatus;
    }

    public PatientEntity getPatient() {
        return patient;
    }
    public void setPatient(PatientEntity patient) {
        this.patient = patient;
    }

    public MedicalStaffEntity getMedicalStaff() {
        return medicalStaff;
    }
    public void setMedicalStaff(MedicalStaffEntity medicalStaff) {
        this.medicalStaff = medicalStaff;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MedicalCaseEntity that = (MedicalCaseEntity) o;
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
}
