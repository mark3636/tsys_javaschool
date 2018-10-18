package ru.tsystems.medicalinstitute.bo;

public class PdfFile {
    private int id;
    private String name;
    private byte[] data;

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

    private MedicalCase medicalCase;
}
