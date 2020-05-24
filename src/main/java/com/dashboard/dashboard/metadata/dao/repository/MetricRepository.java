package com.dashboard.dashboard.metadata.dao.repository;

import com.dashboard.dashboard.metadata.dao.entity.Metric;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetricRepository extends JpaRepository<Metric, Long> {
}
