package ru.tsystems.medicalinstitute.bo;

import java.util.Date;

public class Diagnosis {
    private int id;
    private String name;
    private Date diagnosisDate;
    private String comment;
    private MedicalStaff medicalStaff;

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

    private MedicalCase medicalCase;
}
