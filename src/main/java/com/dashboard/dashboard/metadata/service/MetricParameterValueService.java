package com.dashboard.dashboard.metadata.service;

import com.dashboard.dashboard.metadata.dao.entity.MetricParameter;
import com.dashboard.dashboard.metadata.dao.entity.MetricParameterValue;

import java.util.List;
import java.util.UUID;

public interface MetricParameterValueService {
    List<MetricParameterValue> getMetricParameterValues(Long parameter_id);

    MetricParameterValue createValue(MetricParameterValue value);

    void deleteValueById(Long id);
}
