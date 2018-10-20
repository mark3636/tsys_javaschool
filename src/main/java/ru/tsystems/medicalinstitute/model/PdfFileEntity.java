package ru.tsystems.medicalinstitute.model;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table(name = "pdf_file")
public class PdfFileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "name", nullable = false, length = 20)
    private String name;
    @Column(name = "data", nullable = false)
    private byte[] data;
    @ManyToOne
    @JoinColumn(name = "id_case", nullable = false)
    private MedicalCaseEntity medicalCase;

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

    public byte[] getData() {
        return data;
    }
    public void setData(byte[] data) {
        this.data = data;
    }

    public MedicalCaseEntity getMedicalCase() {
        return medicalCase;
    }
    public void setMedicalCase(MedicalCaseEntity medicalCase) {
        this.medicalCase = medicalCase;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PdfFileEntity that = (PdfFileEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (!Arrays.equals(data, that.data)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(data);
        return result;
    }
}
