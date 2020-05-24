package com.dashboard.dashboard.model.metrics;

import com.dashboard.dashboard.metadata.dao.entity.Metric;
import com.dashboard.dashboard.metadata.dao.entity.MetricParameter;
import com.dashboard.dashboard.metadata.dao.entity.MetricParameterValue;
import com.dashboard.dashboard.model.datasource.MetricDataSource;

import java.util.Map;
import java.util.Set;


public class MetricModel {
    private Set<ComponentModel> components;

    // we need to know the ACTUAL value of parameters;
    private Map<MetricParameter, MetricParameterValue> actualParameters;

    // metadata
    private Metric metric;

    //datasource
    private MetricDataSource dataSource;

    public void calculate() {

    }


}
