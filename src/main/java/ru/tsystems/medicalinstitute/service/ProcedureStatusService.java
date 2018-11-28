package ru.tsystems.medicalinstitute.service;

import ru.tsystems.medicalinstitute.bo.ProcedureStatus;


public interface ProcedureStatusService extends AbstractService<ProcedureStatus> {
    ProcedureStatus getByName(String name);
}
