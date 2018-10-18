package ru.tsystems.medicalinstitute.mappers;

import java.util.List;

public interface TemplateMapper<TBo, TEntity> {
    TBo toBo(TEntity entity);
    TEntity fromBo(TBo bo);
    List<TBo> toBos(List<TEntity> entities);
}
