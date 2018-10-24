package ru.tsystems.medicalinstitute.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "diagnosis")
public class DiagnosisEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "diagnosis_date")
    @Temporal(TemporalType.DATE)
    private Date diagnosisDate;
    @Column(name = "comment")
    private String comment;
    @ManyToOne
    @JoinColumn(name = "id_medical_staff", nullable = false)
    private MedicalStaffEntity medicalStaff;
    @ManyToOne
    @JoinColumn(name = "id_case", nullable = false)
    private MedicalCaseEntity medicalCase;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Date getDiagnosisDate() {
        return diagnosisDate;
    }
    public void setDiagnosisDate(Date diagnosisDate) {
        this.diagnosisDate = diagnosisDate;
    }

    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }

    public MedicalStaffEntity getMedicalStaff() {
        return medicalStaff;
    }
    public void setMedicalStaff(MedicalStaffEntity medicalStaff) {
        this.medicalStaff = medicalStaff;
    }

    public MedicalCaseEntity getMedicalCase() {
        return medicalCase;
    }
    public void setMedicalCase(MedicalCaseEntity medicalCase) {
        this.medicalCase = medicalCase;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DiagnosisEntity entity = (DiagnosisEntity) o;
        return id == entity.id &&
                Objects.equals(name, entity.name) &&
                Objects.equals(diagnosisDate, entity.diagnosisDate) &&
                Objects.equals(comment, entity.comment) &&
                Objects.equals(medicalStaff, entity.medicalStaff) &&
                Objects.equals(medicalCase, entity.medicalCase);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, diagnosisDate, comment, medicalStaff, medicalCase);
    }
}
