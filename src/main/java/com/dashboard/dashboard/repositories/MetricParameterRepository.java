package com.dashboard.dashboard.repositories;

import com.dashboard.dashboard.metrics.MetricParameter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetricParameterRepository
        extends CrudRepository<MetricParameter, Long> {
}
