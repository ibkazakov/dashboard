package com.dashboard.dashboard.metadata.service.impl;

import com.dashboard.dashboard.metadata.dao.entity.Metric;
import com.dashboard.dashboard.metadata.dao.repository.MetricRepository;
import com.dashboard.dashboard.metadata.service.MetricService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Consumer;

@Service
public class MetricServiceImpl implements MetricService {
    @Autowired
    private MetricRepository metricRepository;

    @Override
    public Metric createMetric(Metric metric) {
        String ident = UUID.randomUUID().toString();
        metric.setIdent(ident);
        metricRepository.save(metric);
        return metric;
    }

    @Override
    public Metric updateMetric(Metric metric) {
        // ident, parameters and components should be preserved
        Metric original = metricRepository.getOne(metric.getId());
        metric.setIdent(original.getIdent());
        metric.setParameters(original.getParameters());
        metric.setComponents(original.getComponents());
        metricRepository.save(metric);
        return metric;
    }

    @Override
    public List<Metric> getAllMetrics() {
       List<Metric> metrics = new ArrayList<>();
       metricRepository.findAll().forEach(new Consumer<Metric>() {
           @Override
           public void accept(Metric metric) {
               metrics.add(metric);
           }
       });
       return metrics;
    }

    @Override
    public Metric getMetricById(Long id) {
        return metricRepository.findById(id).get();
    }

    @Override
    public boolean isMetricPresent(Long id) {
       return metricRepository.existsById(id);
    }

    @Override
    public void deleteMetricById(Long id) {
        metricRepository.deleteById(id);
    }

}
