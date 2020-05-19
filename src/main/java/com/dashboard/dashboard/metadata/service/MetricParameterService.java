package com.dashboard.dashboard.metadata.service;

import com.dashboard.dashboard.metadata.metrics.MetricParameter;
import com.dashboard.dashboard.metadata.repositories.MetricParameterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.function.Consumer;

@Service
public class MetricParameterService {
    @Autowired
    private MetricParameterRepository metricParameterRepository;

    public MetricParameter createParameter(String name, boolean isDefault) {
        MetricParameter parameter = new MetricParameter();
        parameter.setName(name);
        parameter.setDefault(isDefault);
        String ident = UUID.randomUUID().toString();
        parameter.setIdent(ident);

        metricParameterRepository.save(parameter);
        return parameter;
    }

    public MetricParameter getParameterById(Long id) {
        return metricParameterRepository.findById(id).get();
    }

    public Set<MetricParameter> allParameters() {
        Set<MetricParameter> parameters = new HashSet<>();
        metricParameterRepository.findAll().forEach(new Consumer<MetricParameter>() {
            @Override
            public void accept(MetricParameter metricParameter) {
                parameters.add(metricParameter);
            }
        });
        return parameters;
    }

    public void updateParameter(MetricParameter parameter) {
        metricParameterRepository.save(parameter);
    }

    public void deleteParameter(Long id) {
        metricParameterRepository.deleteById(id);
    }

}
