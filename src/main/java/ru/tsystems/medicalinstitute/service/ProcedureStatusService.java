package ru.tsystems.medicalinstitute.service;

import ru.tsystems.medicalinstitute.bo.ProcedureStatus;


public interface ProcedureStatusService extends AbstractService<ProcedureStatus> {
    /**
     * Returns ProcedureStatus by its name
     * @param name name of status
     * @return ProcedureStatus
     */
    ProcedureStatus getByName(String name);
}
