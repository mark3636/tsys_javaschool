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
//    private Set<Diagnosis> diagnoses;
//    private Set<PdfFile> pdfFiles;
//    private Set<Visit> visits;

    public MedicalCase() {
//        diagnoses = new HashSet<>();
//        pdfFiles = new HashSet<>();
    }

    public MedicalCase(int id, String number, Date beginningDate, Date endingDate, CaseStatus caseStatus, Patient patient, MedicalStaff medicalStaff/*, Set<Diagnosis> diagnoses, Set<PdfFile> pdfFiles, Set<Visit> visits*/) {
        this.id = id;
        this.number = number;
        this.beginningDate = beginningDate;
        this.endingDate = endingDate;
        this.caseStatus = caseStatus;
        this.patient = patient;
        this.medicalStaff = medicalStaff;
//        this.diagnoses = diagnoses;
//        this.pdfFiles = pdfFiles;
//        this.visits = visits;
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

//    public Set<Diagnosis> getDiagnoses() {
//        return diagnoses;
//    }
//
//    public void setDiagnoses(Set<Diagnosis> diagnoses) {
//        this.diagnoses = diagnoses;
//    }
//
//    public Set<PdfFile> getPdfFiles() {
//        return pdfFiles;
//    }
//
//    public void setPdfFiles(Set<PdfFile> pdfFiles) {
//        this.pdfFiles = pdfFiles;
//    }
//
//    public Set<Visit> getVisits() {
//        return visits;
//    }
//
//    public void setVisits(Set<Visit> visits) {
//        this.visits = visits;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MedicalCase that = (MedicalCase) o;

        if (id != that.id) return false;
        if (number != null ? !number.equals(that.number) : that.number != null) return false;
        if (beginningDate != null ? !beginningDate.equals(that.beginningDate) : that.beginningDate != null)
            return false;
        if (endingDate != null ? !endingDate.equals(that.endingDate) : that.endingDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (beginningDate != null ? beginningDate.hashCode() : 0);
        result = 31 * result + (endingDate != null ? endingDate.hashCode() : 0);
        return result;
    }
}
