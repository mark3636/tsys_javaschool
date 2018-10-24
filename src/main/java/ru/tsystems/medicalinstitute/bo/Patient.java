package ru.tsystems.medicalinstitute.bo;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.util.Date;
import java.util.Objects;

public class Patient {
    private int id;
    @NotEmpty(message = "Name cannot be empty")
    @Size(min = 2, max = 15, message = "Name length should be between 2 to 15")
    private String name;
    @NotEmpty(message = "Surname cannot be empty")
    @Size(min = 2, max = 15, message = "Surname length should be between 2 to 20")
    private String surname;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Birthday should be chosen")
    @Past(message = "Birthday should be in past")
    private Date birthday;
    @NotEmpty(message = "Passport details cannot be empty")
    private String passportDetails;
    @NotEmpty(message = "Address details cannot be empty")
    private String address;
    @NotEmpty(message = "Email cannot be empty")
    @Pattern(regexp = "\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b", message = "Email should be correct")
    private String email;
    @NotEmpty(message = "Phone number cannot be empty")
    @Size(min = 5, max = 11, message = "Phone number length should be between 5 to 11")
    @Pattern(regexp = "\\d{5,11}", message = "Phone number should contain only numbers")
    private String phoneNumber;
    private String comment;
    @NotNull(message = "Social security number cannot be empty")
    @Digits(integer = 9, fraction = 0, message = "Social security number length should be 9")
    private int socialSecurityNumber;

    public Patient() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return id == patient.id &&
                socialSecurityNumber == patient.socialSecurityNumber &&
                Objects.equals(name, patient.name) &&
                Objects.equals(surname, patient.surname) &&
                Objects.equals(birthday, patient.birthday) &&
                Objects.equals(passportDetails, patient.passportDetails) &&
                Objects.equals(address, patient.address) &&
                Objects.equals(email, patient.email) &&
                Objects.equals(phoneNumber, patient.phoneNumber) &&
                Objects.equals(comment, patient.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, birthday, passportDetails, address, email, phoneNumber, comment, socialSecurityNumber);
    }

    public Patient(int id, String name, String surname, Date birthday, String passportDetails, String address, String email, String phoneNumber, String comment, int socialSecurityNumber/*, Set<MedicalCase> medicalCases, Set<Visit> visits*/) {
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

}
