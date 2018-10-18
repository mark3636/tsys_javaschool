package ru.tsystems.medicalinstitute.bo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Patient {
    private int id;
    private String name;
    private String surname;
    private Date birthday;
    private String passportDetails;
    private String address;
    private String email;
    private String phoneNumber;
    private String comment;
    private int socialSecurityNumber;
    private Set<MedicalCase> medicalCases;
    private Set<Visit> visits;

    public Set<Visit> getVisits() {
        return visits;
    }

    public void setVisits(Set<Visit> visits) {
        this.visits = visits;
    }

    public Patient() {
        medicalCases = new HashSet<MedicalCase>();
        visits = new HashSet<Visit>();
    }

    public Patient(int id, String name, String surname, Date birthday, String passportDetails, String address, String email, String phoneNumber, String comment, int socialSecurityNumber, Set<MedicalCase> medicalCases, Set<Visit> visits) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.passportDetails = passportDetails;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.comment = comment;
        this.socialSecurityNumber = socialSecurityNumber;
        this.medicalCases = medicalCases;
        this.visits = visits;
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

    public String getPassportDetails() {
        return passportDetails;
    }

    public void setPassportDetails(String passportDetails) {
        this.passportDetails = passportDetails;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(int socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public Set<MedicalCase> getMedicalCases() {
        return medicalCases;
    }

    public void setMedicalCases(Set<MedicalCase> medicalCases) {
        this.medicalCases = medicalCases;
    }

}
