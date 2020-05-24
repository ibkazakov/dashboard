package com.dashboard.dashboard.metadata.dao.repository;

import com.dashboard.dashboard.metadata.dao.entity.MetricParameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetricParameterRepository
        extends JpaRepository<MetricParameter, Long> {
}
