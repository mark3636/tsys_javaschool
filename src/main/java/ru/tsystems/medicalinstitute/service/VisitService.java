package ru.tsystems.medicalinstitute.service;

import ru.tsystems.medicalinstitute.bo.Visit;

import java.text.ParseException;
import java.util.List;

public interface VisitService extends AbstractService<Visit> {
    /**
     * Lists all visits
     * @return List of visits
     */
    List<Visit> listVisits();

    /**
     * Returns visits by patient
     * @param id patient id
     * @return List of visits
     */
    List<Visit> getByPatientId(int id);

    /**
     * Returns visits by medical staff and visit date
     * @param medicalStaffId medical staff id
     * @param visitDate date of visit
     * @return List of visits
     * @throws ParseException when couldn't parse string as date
     */
    List<Visit> getByMedicalStaffAndVisitDate(int medicalStaffId, String visitDate) throws ParseException;

    /**
     * Returns list of taken medical staff time
     * @param medicalStaffId medical staff id
     * @param visitDate date of visit
     * @return List of time as String
     * @throws ParseException when couldn't parse string as date
     */
    List<String> getExistedTime(int medicalStaffId, String visitDate) throws ParseException;

    /**
     * Returns minimum and maximum time for visit end
     * @param medicalStaffId medical staff id
     * @param visitDate date of visit
     * @param beginningTime beginning time of visit
     * @return List of minimum and maximum time
     * @throws ParseException when couldn't parse string as date or time
     */
    List<String> getEndingTime(int medicalStaffId, String visitDate, String beginningTime) throws ParseException;
}
