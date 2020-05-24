package com.dashboard.dashboard.metadata.service;

import com.dashboard.dashboard.metadata.dao.entity.MetricParameter;
import com.dashboard.dashboard.metadata.dao.entity.MetricParameterValue;
import com.dashboard.dashboard.metadata.dao.repository.MetricParameterValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MetricParameterValueService {
    @Autowired
    private MetricParameterValueRepository metricParameterValueRepository;

    @Autowired
    private MetricParameterService metricParameterService;


    public List<MetricParameterValue> getMetricParameterValues(Long parameter_id) {
        MetricParameter parameter = metricParameterService.getParameterById(parameter_id);
        return parameter.getValues();
    }

    public MetricParameterValue createValue(MetricParameterValue value) {
        String ident = UUID.randomUUID().toString();
        value.setIdent(ident);
        metricParameterValueRepository.save(value);
        return value;
    }


    public void deleteValueById(Long id) {
        metricParameterValueRepository.deleteById(id);
    }
}
