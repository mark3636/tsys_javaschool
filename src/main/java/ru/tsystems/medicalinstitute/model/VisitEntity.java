package ru.tsystems.medicalinstitute.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "visit")
public class VisitEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "beginning_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date beginningDate;
    @Column(name = "ending_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date endingDate;
    @ManyToOne
    @JoinColumn(name = "id_medical_staff", nullable = false)
    private MedicalStaffEntity medicalStaff;
    @ManyToOne
    @JoinColumn(name = "id_patient", nullable = false)
    private PatientEntity patient;

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

    public MedicalStaffEntity getMedicalStaff() {
        return medicalStaff;
    }
    public void setMedicalStaff(MedicalStaffEntity medicalStaff) {
        this.medicalStaff = medicalStaff;
    }

    public PatientEntity getPatient() {
        return patient;
    }
    public void setPatient(PatientEntity patient) {
        this.patient = patient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VisitEntity that = (VisitEntity) o;
        return id == that.id &&
                Objects.equals(beginningDate, that.beginningDate) &&
                Objects.equals(endingDate, that.endingDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, beginningDate, endingDate);
    }
}
