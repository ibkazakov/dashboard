package com.dashboard.dashboard.repositories;

import com.dashboard.dashboard.metrics.MetricParameterValue;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetricParameterValueRepository
        extends CrudRepository<MetricParameterValue, Long> {
}
