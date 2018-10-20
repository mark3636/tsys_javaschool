package ru.tsystems.medicalinstitute.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "case_status")
public class CaseStatusEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "name", nullable = false, length = 20)
    private String name;
    @Column(name = "description", length = 200)
    private String description;
//    @OneToMany(mappedBy = "caseStatus", cascade = CascadeType.ALL, orphanRemoval = true)
//    private Set<MedicalCaseEntity> medicalCases;

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

//    public Set<MedicalCaseEntity> getMedicalCases() {
//        return medicalCases;
//    }
//    public void setMedicalCases(Set<MedicalCaseEntity> medicalCases) {
//        this.medicalCases = medicalCases;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CaseStatusEntity that = (CaseStatusEntity) o;

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
