package ru.tsystems.medicalinstitute.bo;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

public class MedicalProcedure {
    private int id;
    @NotEmpty(message = "Procedure name cannot be empty")
    private String name;
    private String description;
    private String comment;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date procedureDate;
    private MedicalStaff medicalStaff;
    private MedicalCase medicalCase;
    private ProcedureStatus procedureStatus;

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

    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getProcedureDate() {
        return procedureDate;
    }
    public void setProcedureDate(Date procedureDate) {
        this.procedureDate = procedureDate;
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

    public ProcedureStatus getProcedureStatus() {
        return procedureStatus;
    }
    public void setProcedureStatus(ProcedureStatus procedureStatus) {
        this.procedureStatus = procedureStatus;
    }
}
