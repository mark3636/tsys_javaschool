package ru.tsystems.medicalinstitute.bo;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.util.Date;
import java.util.Objects;

public class MedicalStaff {
    private int id;
    @NotEmpty(message = "Name cannot be empty")
    @Size(min = 2, max = 15, message = "Name length should be between 2 to 15")
    @Pattern(regexp = "^[\\p{L} .'-]+$", message = "Name should contain only letters and such symbols as '.-")
    private String name;
    @NotEmpty(message = "Surname cannot be empty")
    @Size(min = 2, max = 20, message = "Surname length should be between 2 to 20")
    @Pattern(regexp = "^[\\p{L} .'-]+$", message = "Surname should contain only letters and such symbols as '.-")
    private String surname;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Birthday should be chosen")
    @Past(message = "Birthday should be in past")
    private Date birthday;
    @NotEmpty(message = "Password cannot be empty")
    @Size(min = 4, max = 15, message = "Password length should be between 4 to 15")
    private String password;
    @NotEmpty(message = "Email cannot be empty")
    @Email(message = "Email should be correct")
    private String email;

    public MedicalStaff() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MedicalStaff that = (MedicalStaff) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(surname, that.surname) &&
                Objects.equals(birthday, that.birthday) &&
                Objects.equals(password, that.password) &&
                Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, birthday, password, email);
    }

    public MedicalStaff(int id, String name, String surname, Date birthday, String password, String email) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.password = password;
        this.email = email;
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

}
