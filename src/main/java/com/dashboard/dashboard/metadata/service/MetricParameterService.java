package com.dashboard.dashboard.metadata.service;

import com.dashboard.dashboard.metadata.dao.entity.MetricParameter;
import java.util.List;


public interface MetricParameterService {
    MetricParameter createParameter(MetricParameter parameter);

    void deleteParameterById(Long id);

    boolean isParameterPresent(Long id);

    MetricParameter updateParameter(MetricParameter parameter);

    MetricParameter getParameterById(Long id);

    List<MetricParameter> getMetricParameters(Long metric_id);
}
