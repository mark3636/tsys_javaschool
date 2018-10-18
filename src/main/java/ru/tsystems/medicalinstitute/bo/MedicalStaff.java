package ru.tsystems.medicalinstitute.bo;

import java.util.Date;
import java.util.Set;

public class MedicalStaff {
    private int id;
    private String name;
    private String surname;
    private Date birthday;
    private String password;
    private String email;
    private Set<Diagnosis> diagnoses;
    private Set<MedicalCase> medicalCases;
    private Set<Visit> visits;

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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Diagnosis> getDiagnoses() {
        return diagnoses;
    }

    public void setDiagnoses(Set<Diagnosis> diagnoses) {
        this.diagnoses = diagnoses;
    }

    public Set<MedicalCase> getMedicalCases() {
        return medicalCases;
    }

    public void setMedicalCases(Set<MedicalCase> medicalCases) {
        this.medicalCases = medicalCases;
    }

    public Set<Visit> getVisits() {
        return visits;
    }

    public void setVisits(Set<Visit> visits) {
        this.visits = visits;
    }

    public MedicalStaff() {
    }

    public MedicalStaff(int id, String name, String surname, Date birthday, String password, String email, Set<Diagnosis> diagnoses, Set<MedicalCase> medicalCases, Set<Visit> visits) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.password = password;
        this.email = email;
        this.diagnoses = diagnoses;
        this.medicalCases = medicalCases;
        this.visits = visits;
    }
}
