package com.dashboard.dashboard.metadata.service.impl;

import com.dashboard.dashboard.metadata.dao.entity.Metric;
import com.dashboard.dashboard.metadata.dao.entity.MetricParameter;
import com.dashboard.dashboard.metadata.dao.repository.MetricParameterRepository;
import com.dashboard.dashboard.metadata.service.MetricParameterService;
import com.dashboard.dashboard.metadata.service.MetricService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Consumer;

@Service
public class MetricParameterServiceImpl implements MetricParameterService {
    @Autowired
    private MetricParameterRepository metricParameterRepository;

    @Autowired
    private MetricService metricService;

    @Override
    public MetricParameter createParameter(MetricParameter parameter) {
        String ident = UUID.randomUUID().toString();
        parameter.setIdent(ident);
        metricParameterRepository.save(parameter);
        return parameter;
    }

    @Override
    public void deleteParameterById(Long id) {
        metricParameterRepository.deleteById(id);
    }

    @Override
    public boolean isParameterPresent(Long id) {
        return metricParameterRepository.existsById(id);
    }

    @Override
    public MetricParameter updateParameter(MetricParameter parameter) {
        // ident, values and bind to the metric should be preserved
        MetricParameter original = metricParameterRepository.getOne(parameter.getId());
        parameter.setIdent(original.getIdent());
        parameter.setMetric(original.getMetric());
        parameter.setValues(original.getValues());
        metricParameterRepository.save(parameter);
        return parameter;
    }

    @Override
    public MetricParameter getParameterById(Long id) {
        return metricParameterRepository.findById(id).get();
    }

    @Override
    public List<MetricParameter> getMetricParameters(Long metric_id) {
        Metric metric = metricService.getMetricById(metric_id);
        return metric.getParameters();
    }
}
