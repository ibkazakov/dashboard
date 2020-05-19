package com.dashboard.dashboard.metadata.service;

import com.dashboard.dashboard.metadata.metrics.MetricParameter;
import com.dashboard.dashboard.metadata.metrics.MetricParameterValue;
import com.dashboard.dashboard.metadata.repositories.MetricParameterValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.function.Consumer;

@Service
public class MetricParameterValueService {
    @Autowired
    private MetricParameterValueRepository metricParameterValueRepository;

    @Autowired
    private MetricParameterService metricParameterService;

    public MetricParameterValue createValue(String name, String description,
                                            boolean isDefault, Long parameter_id) {
        MetricParameterValue value = new MetricParameterValue();
        value.setName(name);
        value.setDefault(isDefault);
        value.setDescription(description);
        String ident = UUID.randomUUID().toString();
        value.setIdent(ident);

        MetricParameter parameter =
                metricParameterService.getParameterById(parameter_id);
        parameter.getValues().add(value);
        value.setParameter(parameter);

        metricParameterValueRepository.save(value);
        metricParameterService.updateParameter(parameter);
        return value;
    }

    public Set<MetricParameterValue> allValues() {
        Set<MetricParameterValue> parameterValues = new HashSet<>();
        metricParameterValueRepository.findAll().forEach(new Consumer<MetricParameterValue>() {
            @Override
            public void accept(MetricParameterValue metricParameterValue) {
                parameterValues.add(metricParameterValue);
            }
        });
        return parameterValues;
    }

    public void deleteValue(Long id) {
        metricParameterValueRepository.deleteById(id);
    }
}
