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
    @Column(name = "visit_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date visitDate;
    @Column(name = "beginning_time")
    @DateTimeFormat(pattern = "HH:mm")
    @Temporal(TemporalType.TIME)
    private Date beginningTime;
    @Column(name = "ending_time")
    @DateTimeFormat(pattern = "HH:mm")
    @Temporal(TemporalType.TIME)
    private Date endingTime;
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
                Objects.equals(visitDate, that.visitDate) &&
                Objects.equals(beginningTime, that.beginningTime) &&
                Objects.equals(endingTime, that.endingTime) &&
                Objects.equals(medicalStaff, that.medicalStaff) &&
                Objects.equals(patient, that.patient);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, visitDate, beginningTime, endingTime, medicalStaff, patient);
    }
}
