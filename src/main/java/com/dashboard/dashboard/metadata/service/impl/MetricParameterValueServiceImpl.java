package com.dashboard.dashboard.metadata.service.impl;

import com.dashboard.dashboard.metadata.dao.entity.MetricParameter;
import com.dashboard.dashboard.metadata.dao.entity.MetricParameterValue;
import com.dashboard.dashboard.metadata.dao.repository.MetricParameterValueRepository;
import com.dashboard.dashboard.metadata.service.MetricParameterService;
import com.dashboard.dashboard.metadata.service.MetricParameterValueService;
import com.dashboard.dashboard.metadata.service.impl.MetricParameterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MetricParameterValueServiceImpl implements MetricParameterValueService {
    @Autowired
    private MetricParameterValueRepository metricParameterValueRepository;

    @Autowired
    private MetricParameterService metricParameterService;

    @Override
    public List<MetricParameterValue> getMetricParameterValues(Long parameter_id) {
        MetricParameter parameter = metricParameterService.getParameterById(parameter_id);
        return parameter.getValues();
    }

    @Override
    public MetricParameterValue createValue(MetricParameterValue value) {
        String ident = UUID.randomUUID().toString();
        value.setIdent(ident);
        metricParameterValueRepository.save(value);
        return value;
    }

    @Override
    public void deleteValueById(Long id) {
        metricParameterValueRepository.deleteById(id);
    }
}
