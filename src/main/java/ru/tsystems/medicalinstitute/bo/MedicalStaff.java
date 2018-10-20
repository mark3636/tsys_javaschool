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
//    private Set<Diagnosis> diagnoses;
//    private Set<MedicalCase> medicalCases;
//    private Set<Visit> visits;

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

//    public Set<Diagnosis> getDiagnoses() {
//        return diagnoses;
//    }
//
//    public void setDiagnoses(Set<Diagnosis> diagnoses) {
//        this.diagnoses = diagnoses;
//    }
//
//    public Set<MedicalCase> getMedicalCases() {
//        return medicalCases;
//    }
//
//    public void setMedicalCases(Set<MedicalCase> medicalCases) {
//        this.medicalCases = medicalCases;
//    }
//
//    public Set<Visit> getVisits() {
//        return visits;
//    }
//
//    public void setVisits(Set<Visit> visits) {
//        this.visits = visits;
//    }

    public MedicalStaff() {
    }

    public MedicalStaff(int id, String name, String surname, Date birthday, String password, String email/*, Set<Diagnosis> diagnoses, Set<MedicalCase> medicalCases, Set<Visit> visits*/) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.password = password;
        this.email = email;
//        this.diagnoses = diagnoses;
//        this.medicalCases = medicalCases;
//        this.visits = visits;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MedicalStaff that = (MedicalStaff) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (surname != null ? !surname.equals(that.surname) : that.surname != null) return false;
        if (birthday != null ? !birthday.equals(that.birthday) : that.birthday != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }
}
