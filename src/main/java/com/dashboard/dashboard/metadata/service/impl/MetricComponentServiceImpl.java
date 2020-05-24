package com.dashboard.dashboard.metadata.service.impl;

import com.dashboard.dashboard.metadata.dao.entity.Metric;
import com.dashboard.dashboard.metadata.dao.entity.MetricComponent;
import com.dashboard.dashboard.metadata.dao.repository.MetricComponentRepository;
import com.dashboard.dashboard.metadata.service.MetricComponentService;
import com.dashboard.dashboard.metadata.service.MetricService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MetricComponentServiceImpl implements MetricComponentService {
    @Autowired
    private MetricComponentRepository metricComponentRepository;

    @Autowired
    private MetricService metricService;

    @Override
    public MetricComponent createComponent(MetricComponent metricComponent) {
        String ident = UUID.randomUUID().toString();
        metricComponent.setIdent(ident);
        metricComponentRepository.save(metricComponent);
        return metricComponent;
    }

    @Override
    public List<MetricComponent> getMetricComponents(Long metric_id) {
        Metric metric = metricService.getMetricById(metric_id);
        return metric.getComponents();
    }

    @Override
    public MetricComponent updateComponent(MetricComponent component) {
        // ident and bind to the metric should be preserved
        MetricComponent original = metricComponentRepository.getOne(component.getId());
        component.setIdent(original.getIdent());
        component.setMetric(original.getMetric());
        metricComponentRepository.save(component);
        return component;
    }

    @Override
    public boolean isComponentPresent(Long id) {
        return metricComponentRepository.existsById(id);
    }

    @Override
    public void deleteComponentById(Long id) {
        metricComponentRepository.deleteById(id);
    }
}
