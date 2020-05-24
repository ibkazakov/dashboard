package com.dashboard.dashboard.metadata.dao.repository;

import com.dashboard.dashboard.metadata.dao.entity.MetricComponent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetricComponentRepository
        extends JpaRepository<MetricComponent, Long> {
}
