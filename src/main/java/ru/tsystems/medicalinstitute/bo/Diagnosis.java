package ru.tsystems.medicalinstitute.bo;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.Objects;

public class Diagnosis {
    private int id;
    @NotEmpty(message = "Diagnosis name cannot be empty")
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date diagnosisDate;
    private String comment;
    private MedicalStaff medicalStaff;
    private MedicalCase medicalCase;

    public Diagnosis() {
    }

    public Diagnosis(int id, String name, Date diagnosisDate, String comment, MedicalStaff medicalStaff, MedicalCase medicalCase) {
        this.id = id;
        this.name = name;
        this.diagnosisDate = diagnosisDate;
        this.comment = comment;
        this.medicalStaff = medicalStaff;
        this.medicalCase = medicalCase;
    }

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

    public MedicalStaff getMedicalStaff() {
        return medicalStaff;
    }
    public void setMedicalStaff(MedicalStaff medicalStaff) {
        this.medicalStaff = medicalStaff;
    }

    public MedicalCase getMedicalCase() {
        return medicalCase;
    }
    public void setMedicalCase(MedicalCase medicalCase) {
        this.medicalCase = medicalCase;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Diagnosis diagnosis = (Diagnosis) o;
        return id == diagnosis.id &&
                Objects.equals(name, diagnosis.name) &&
                Objects.equals(diagnosisDate, diagnosis.diagnosisDate) &&
                Objects.equals(comment, diagnosis.comment) &&
                Objects.equals(medicalStaff, diagnosis.medicalStaff) &&
                Objects.equals(medicalCase, diagnosis.medicalCase);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, diagnosisDate, comment, medicalStaff, medicalCase);
    }
}
