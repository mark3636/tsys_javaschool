package ru.tsystems.medicalinstitute.bo;

import ru.tsystems.medicalinstitute.model.DiagnosisEntity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class MedicalCase {
    private int id;
    private String number;
    private Date beginningDate;
    private Date endingDate;
    private CaseStatus caseStatus;
    private Patient patient;
    private MedicalStaff medicalStaff;
    private Set<Diagnosis> diagnoses;
    private Set<PdfFile> pdfFiles;

    public MedicalCase() {
        diagnoses = new HashSet<>();
        pdfFiles = new HashSet<>();
    }

    public MedicalCase(int id, String number, Date beginningDate, Date endingDate, CaseStatus caseStatus, Patient patient, MedicalStaff medicalStaff, Set<Diagnosis> diagnoses, Set<PdfFile> pdfFiles, Set<Visit> visits) {
        this.id = id;
        this.number = number;
        this.beginningDate = beginningDate;
        this.endingDate = endingDate;
        this.caseStatus = caseStatus;
        this.patient = patient;
        this.medicalStaff = medicalStaff;
        this.diagnoses = diagnoses;
        this.pdfFiles = pdfFiles;
        this.visits = visits;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getBeginningDate() {
        return beginningDate;
    }

    public void setBeginningDate(Date beginningDate) {
        this.beginningDate = beginningDate;
    }

    public Date getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(Date endingDate) {
        this.endingDate = endingDate;
    }

    public CaseStatus getCaseStatus() {
        return caseStatus;
    }

    public void setCaseStatus(CaseStatus caseStatus) {
        this.caseStatus = caseStatus;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public MedicalStaff getMedicalStaff() {
        return medicalStaff;
    }

    public void setMedicalStaff(MedicalStaff medicalStaff) {
        this.medicalStaff = medicalStaff;
    }

    public Set<Diagnosis> getDiagnoses() {
        return diagnoses;
    }

    public void setDiagnoses(Set<Diagnosis> diagnoses) {
        this.diagnoses = diagnoses;
    }

    public Set<PdfFile> getPdfFiles() {
        return pdfFiles;
    }

    public void setPdfFiles(Set<PdfFile> pdfFiles) {
        this.pdfFiles = pdfFiles;
    }

    public Set<Visit> getVisits() {
        return visits;
    }

    public void setVisits(Set<Visit> visits) {
        this.visits = visits;
    }

    private Set<Visit> visits;
}
