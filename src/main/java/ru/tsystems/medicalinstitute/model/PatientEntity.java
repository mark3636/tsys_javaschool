package ru.tsystems.medicalinstitute.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "patient")
public class PatientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "name", length = 15)
    private String name;
    @Column(name = "surname", length = 20)
    private String surname;
    @Column(name = "birthday")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date birthday;
    @Column(name = "passport_details", length = 200)
    private String passportDetails;
    @Column(name = "address", length = 200)
    private String address;
    @Column(name = "email", length = 30)
    private String email;
    @Column(name = "phone_number", nullable = false, length = 20)
    private String phoneNumber;
    @Column(name = "comment", length = 1000)
    private String comment;
    @Column(name = "social_security_number", nullable = false, length = 11)
    private int socialSecurityNumber;
//    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
//    private Set<MedicalCaseEntity> medicalCases;
//    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
//    private Set<VisitEntity> visits;

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

//    public Set<MedicalCaseEntity> getMedicalCases() {
//        return medicalCases;
//    }
//    public void setMedicalCases(Set<MedicalCaseEntity> medicalCases) {
//        this.medicalCases = medicalCases;
//    }
//
//    public Set<VisitEntity> getVisits() {
//        return visits;
//    }
//    public void setVisits(Set<VisitEntity> visits) {
//        this.visits = visits;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PatientEntity that = (PatientEntity) o;

        if (id != that.id) return false;
        if (socialSecurityNumber != that.socialSecurityNumber) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (surname != null ? !surname.equals(that.surname) : that.surname != null) return false;
        if (birthday != null ? !birthday.equals(that.birthday) : that.birthday != null) return false;
        if (passportDetails != null ? !passportDetails.equals(that.passportDetails) : that.passportDetails != null)
            return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (phoneNumber != null ? !phoneNumber.equals(that.phoneNumber) : that.phoneNumber != null) return false;
        if (comment != null ? !comment.equals(that.comment) : that.comment != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (passportDetails != null ? passportDetails.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + socialSecurityNumber;
        return result;
    }
}
