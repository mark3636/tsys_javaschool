package ru.tsystems.medicalinstitute.bo;

import java.util.HashSet;
import java.util.Set;

public class CaseStatus {
    private int id;
    private String name;
    private String description;
    private Set<MedicalCase> medicalCases;

    public CaseStatus() {
        medicalCases = new HashSet<>();
    }

    public CaseStatus(int id, String name, String description, Set<MedicalCase> medicalCases) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.medicalCases = medicalCases;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<MedicalCase> getMedicalCases() {
        return medicalCases;
    }

    public void setMedicalCases(Set<MedicalCase> medicalCases) {
        this.medicalCases = medicalCases;
    }
}
