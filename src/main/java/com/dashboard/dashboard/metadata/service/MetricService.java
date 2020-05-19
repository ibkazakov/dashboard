package com.dashboard.dashboard.metadata.service;

import com.dashboard.dashboard.metadata.dto.MetricDTO;
import com.dashboard.dashboard.metadata.mapper.MetricMapper;
import com.dashboard.dashboard.metadata.metrics.Metric;
import com.dashboard.dashboard.metadata.metrics.MetricComponent;
import com.dashboard.dashboard.metadata.metrics.MetricParameter;
import com.dashboard.dashboard.metadata.repositories.MetricRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.function.Consumer;

@Service
public class MetricService {
    @Autowired
    private MetricRepository metricRepository;

    @Autowired
    private MetricComponentService metricComponentService;

    @Autowired
    private MetricParameterService metricParameterService;


    // CRUD
    public Metric createMetric(String name, boolean hasDatasource)  {
        Metric metric = new Metric();
        metric.setName(name);
        metric.setHasDatasource(hasDatasource);
        String ident = UUID.randomUUID().toString();
        metric.setIdent(ident);

        metricRepository.save(metric);
        return metric;
    }

    public Set<Metric> allMetrics() {
        Set<Metric> allMetric = new HashSet<Metric>();
        metricRepository.findAll().forEach(new Consumer<Metric>() {
            @Override
            public void accept(Metric metric) {
                allMetric.add(metric);
            }
        });
        return allMetric;
    }

    // binding metric with parameter
    public void addParameter(Long id, Long parameter_id) {
        Metric metric = metricRepository.findById(id).get();
        MetricParameter parameter =
                metricParameterService.getParameterById(parameter_id);
        metric.getParameters().add(parameter);
        parameter.setMetric(metric);
        metricRepository.save(metric);
        metricParameterService.updateParameter(parameter);
    }

    // binding metric with component
    public void addComponent(Long id, Long component_id) {
        Metric metric = metricRepository.findById(id).get();
        MetricComponent component =
                metricComponentService.getComponentById(component_id);
        metric.getComponents().add(component);
        component.setMetric(metric);
        metricRepository.save(metric);
        metricComponentService.updateComponent(component);
    }

    // unbinding
    public void removeParameter(Long id, Long parameter_id) {
        MetricParameter parameter =
                metricParameterService.getParameterById(parameter_id);
        parameter.setMetric(null);
        metricParameterService.updateParameter(parameter);
    }

    // unbinding
    public void removeComponent(Long component_id) {
        MetricComponent component =
                metricComponentService.getComponentById(component_id);
        component.setMetric(null);
        metricComponentService.updateComponent(component);
    }

    public void deleteMetricById(Long id) {
        metricRepository.deleteById(id);
    }

}
