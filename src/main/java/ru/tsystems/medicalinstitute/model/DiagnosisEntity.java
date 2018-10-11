package ru.tsystems.medicalinstitute.model;

import javax.persistence.*;
import java.util.Date;

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

        DiagnosisEntity that = (DiagnosisEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (diagnosisDate != null ? !diagnosisDate.equals(that.diagnosisDate) : that.diagnosisDate != null)
            return false;
        if (comment != null ? !comment.equals(that.comment) : that.comment != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (diagnosisDate != null ? diagnosisDate.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        return result;
    }
}
