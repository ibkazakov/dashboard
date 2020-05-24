package com.dashboard.dashboard.metadata.service;

import com.dashboard.dashboard.metadata.dao.entity.Metric;
import com.dashboard.dashboard.metadata.dao.entity.MetricComponent;
import com.dashboard.dashboard.metadata.dao.repository.MetricComponentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MetricComponentService {
    @Autowired
    private MetricComponentRepository metricComponentRepository;

    @Autowired
    private MetricComponentTypeService metricComponentTypeService;

    @Autowired
    private MetricService metricService;


    public MetricComponent createComponent(MetricComponent metricComponent) {
        String ident = UUID.randomUUID().toString();
        metricComponent.setIdent(ident);
        metricComponentRepository.save(metricComponent);
        return metricComponent;
    }

    public List<MetricComponent> getMetricComponents(Long metric_id) {
        Metric metric = metricService.getMetricById(metric_id);
        return metric.getComponents();
    }

    public MetricComponent updateComponent(MetricComponent component) {
        // ident and bind to the metric should be preserved
        MetricComponent original = metricComponentRepository.getOne(component.getId());
        component.setIdent(original.getIdent());
        component.setMetric(original.getMetric());
        metricComponentRepository.save(component);
        return component;
    }

    public boolean isComponentPresent(Long id) {
        return metricComponentRepository.existsById(id);
    }

    public void deleteComponentById(Long id) {
        metricComponentRepository.deleteById(id);
    }
}
