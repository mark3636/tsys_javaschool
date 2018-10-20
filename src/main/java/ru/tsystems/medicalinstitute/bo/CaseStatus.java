package ru.tsystems.medicalinstitute.bo;

import java.util.HashSet;
import java.util.Set;

public class CaseStatus {
    private int id;
    private String name;
    private String description;
    //private Set<MedicalCase> medicalCases;

    public CaseStatus() {
        //medicalCases = new HashSet<>();
    }

    public CaseStatus(int id, String name, String description/*, Set<MedicalCase> medicalCases*/) {
        this.id = id;
        this.name = name;
        this.description = description;
        //this.medicalCases = medicalCases;
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

//    public Set<MedicalCase> getMedicalCases() {
//        return medicalCases;
//    }
//
//    public void setMedicalCases(Set<MedicalCase> medicalCases) {
//        this.medicalCases = medicalCases;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CaseStatus that = (CaseStatus) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
