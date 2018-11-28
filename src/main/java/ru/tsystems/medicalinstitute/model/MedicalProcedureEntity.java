package ru.tsystems.medicalinstitute.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "medical_procedure")
public class MedicalProcedureEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "name", nullable = false, length = 100)
    private String name;
    @Column(name = "description", length = 1000)
    private String description;
    @Column(name = "comment", length = 1000)
    private String comment;
    @Column(name = "procedure_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @Temporal(TemporalType.TIMESTAMP)
    private Date procedureDate;
    @ManyToOne
    @JoinColumn(name = "id_medical_staff")
    private MedicalStaffEntity medicalStaff;
    @ManyToOne
    @JoinColumn(name = "id_case", nullable = false)
    private MedicalCaseEntity medicalCase;
    @ManyToOne
    @JoinColumn(name = "id_status", nullable = false)
    private ProcedureStatusEntity procedureStatus;

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

    public MedicalStaffEntity getMedicalStaff() {
        return medicalStaff;
    }
    public void setMedicalStaff(MedicalStaffEntity medicalStaff) {
        this.medicalStaff = medicalStaff;
    }

    public MedicalCaseEntity getMedicalCase() {
        return medicalCase;
    }
    public void setMedicalCase(MedicalCaseEntity medicalCase) {
        this.medicalCase = medicalCase;
    }

    public ProcedureStatusEntity getProcedureStatus() {
        return procedureStatus;
    }
    public void setProcedureStatus(ProcedureStatusEntity procedureStatus) {
        this.procedureStatus = procedureStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MedicalProcedureEntity that = (MedicalProcedureEntity) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(description, that.description) &&
                Objects.equals(comment, that.comment) &&
                Objects.equals(procedureDate, that.procedureDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, comment, procedureDate);
    }
}
