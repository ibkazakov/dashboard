package com.dashboard.dashboard.repositories;

import com.dashboard.dashboard.metrics.Metric;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetricRepository
        extends CrudRepository<Metric, Long> {
}
