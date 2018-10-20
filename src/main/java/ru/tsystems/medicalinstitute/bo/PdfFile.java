package ru.tsystems.medicalinstitute.bo;

import java.util.Arrays;

public class PdfFile {
    private int id;
    private String name;
    private byte[] data;
    private MedicalCase medicalCase;

    public PdfFile() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PdfFile that = (PdfFile) o;

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
