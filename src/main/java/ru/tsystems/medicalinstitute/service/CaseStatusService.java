package ru.tsystems.medicalinstitute.service;

import ru.tsystems.medicalinstitute.bo.CaseStatus;

public interface CaseStatusService extends AbstractService<CaseStatus> {
    CaseStatus getByName(String name);
}
