package com.dashboard.dashboard.metadata.repositories;

import com.dashboard.dashboard.metadata.metrics.MetricParameter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetricParameterRepository
        extends CrudRepository<MetricParameter, Long> {
}
