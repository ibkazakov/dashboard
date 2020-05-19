package com.dashboard.dashboard.metadata.repositories;

import com.dashboard.dashboard.metadata.metrics.MetricComponentType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetricComponentTypeRepository
        extends CrudRepository<MetricComponentType, Long> {
}