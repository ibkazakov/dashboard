package com.dashboard.dashboard.metadata.repositories;

import com.dashboard.dashboard.metadata.metrics.MetricParameterValue;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetricParameterValueRepository
        extends CrudRepository<MetricParameterValue, Long> {
}
