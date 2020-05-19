package com.dashboard.dashboard.metadata.repositories;

import com.dashboard.dashboard.metadata.metrics.MetricComponent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetricComponentRepository
        extends CrudRepository<MetricComponent, Long> {
}
