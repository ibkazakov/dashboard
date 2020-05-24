package com.dashboard.dashboard.metadata.service;

import com.dashboard.dashboard.metadata.dao.entity.Metric;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;

public interface MetricService {
    Metric createMetric(Metric metric);

    Metric updateMetric(Metric metric);

    List<Metric> getAllMetrics();

    Metric getMetricById(Long id);

    boolean isMetricPresent(Long id);

    void deleteMetricById(Long id);
}
