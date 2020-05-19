package com.dashboard.dashboard.metadata.repositories;

import com.dashboard.dashboard.metadata.metrics.Metric;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetricRepository
        extends CrudRepository<Metric, Long> {
}
