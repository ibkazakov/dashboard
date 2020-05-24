package com.dashboard.dashboard.metadata.service;

import com.dashboard.dashboard.metadata.dao.entity.MetricParameter;
import com.dashboard.dashboard.metadata.dao.repository.MetricParameterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Consumer;

@Service
public class MetricParameterService {
    @Autowired
    private MetricParameterRepository metricParameterRepository;


    public MetricParameter createParameter(MetricParameter parameter) {
        String ident = UUID.randomUUID().toString();
        parameter.setIdent(ident);
        metricParameterRepository.save(parameter);
        return parameter;
    }

    public void deleteParameterById(Long id) {
        metricParameterRepository.deleteById(id);
    }

    public boolean isParameterPresent(Long id) {
        return metricParameterRepository.existsById(id);
    }

    public MetricParameter updateParameter(MetricParameter parameter) {
        // ident, values and bind to the metric should be preserved
        MetricParameter original = metricParameterRepository.getOne(parameter.getId());
        parameter.setIdent(original.getIdent());
        parameter.setMetric(original.getMetric());
        parameter.setValues(original.getValues());
        metricParameterRepository.save(parameter);
        return parameter;
    }


    public MetricParameter getParameterById(Long id) {
        return metricParameterRepository.findById(id).get();
    }

    public List<MetricParameter> allParameters() {
        List<MetricParameter> parameters = new ArrayList<>();
        metricParameterRepository.findAll().forEach(new Consumer<MetricParameter>() {
            @Override
            public void accept(MetricParameter metricParameter) {
                parameters.add(metricParameter);
            }
        });
        return parameters;
    }



}
