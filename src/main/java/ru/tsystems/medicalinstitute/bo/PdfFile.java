package ru.tsystems.medicalinstitute.bo;

import java.util.Arrays;
import java.util.Objects;

public class PdfFile {
    private int id;
    private String name;
    private byte[] data;
    private MedicalCase medicalCase;

    public PdfFile() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PdfFile pdfFile = (PdfFile) o;
        return id == pdfFile.id &&
                Objects.equals(name, pdfFile.name) &&
                Arrays.equals(data, pdfFile.data) &&
                Objects.equals(medicalCase, pdfFile.medicalCase);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, name, medicalCase);
        result = 31 * result + Arrays.hashCode(data);
        return result;
    }

    public PdfFile(int id, String name, byte[] data, MedicalCase medicalCase) {
        this.id = id;
        this.name = name;
        this.data = data;
        this.medicalCase = medicalCase;
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

    public byte[] getData() {
        return data;
    }
    public void setData(byte[] data) {
        this.data = data;
    }

    public MedicalCase getMedicalCase() {
        return medicalCase;
    }
    public void setMedicalCase(MedicalCase medicalCase) {
        this.medicalCase = medicalCase;
    }

}
