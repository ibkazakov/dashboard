package com.dashboard.dashboard.metadata.dao.repository;

import com.dashboard.dashboard.metadata.dao.entity.MetricComponentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetricComponentTypeRepository
        extends JpaRepository<MetricComponentType, Long> {
}
