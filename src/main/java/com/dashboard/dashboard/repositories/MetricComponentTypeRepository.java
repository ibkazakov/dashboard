package com.dashboard.dashboard.repositories;

import com.dashboard.dashboard.metrics.MetricComponentType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetricComponentTypeRepository
        extends CrudRepository<MetricComponentType, Long> {
}
