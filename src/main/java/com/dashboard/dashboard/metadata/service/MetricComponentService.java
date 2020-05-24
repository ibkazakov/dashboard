package com.dashboard.dashboard.metadata.service;

import com.dashboard.dashboard.metadata.dao.entity.Metric;
import com.dashboard.dashboard.metadata.dao.entity.MetricComponent;

import java.util.List;
import java.util.UUID;

public interface MetricComponentService {
    MetricComponent createComponent(MetricComponent metricComponent);

    List<MetricComponent> getMetricComponents(Long metric_id);

    MetricComponent updateComponent(MetricComponent component);

    boolean isComponentPresent(Long id);

    void deleteComponentById(Long id);
}
