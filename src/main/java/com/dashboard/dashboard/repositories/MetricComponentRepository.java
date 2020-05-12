package com.dashboard.dashboard.repositories;

import com.dashboard.dashboard.metrics.MetricComponent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetricComponentRepository
        extends CrudRepository<MetricComponent, Long> {
}
