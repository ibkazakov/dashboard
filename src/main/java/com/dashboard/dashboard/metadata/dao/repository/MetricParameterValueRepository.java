package com.dashboard.dashboard.metadata.dao.repository;

import com.dashboard.dashboard.metadata.dao.entity.MetricParameterValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetricParameterValueRepository
        extends JpaRepository<MetricParameterValue, Long> {
}
