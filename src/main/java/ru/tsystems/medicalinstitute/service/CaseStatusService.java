package ru.tsystems.medicalinstitute.service;

import ru.tsystems.medicalinstitute.bo.CaseStatus;

public interface CaseStatusService extends AbstractService<CaseStatus> {
    /**
     * Returns CaseStatus by its name
     * @param name CaseStatus name
     * @return CaseStatus
     */
    CaseStatus getByName(String name);
}
