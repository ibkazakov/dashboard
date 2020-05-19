package com.dashboard.dashboard.metadata.dto;

import com.dashboard.dashboard.metadata.metrics.Metric;
import com.dashboard.dashboard.metadata.metrics.MetricComponentType;
import lombok.Data;

import javax.persistence.*;

@Data
public class MetricComponentDTO {

    private Long id;
    private String ident;
    private String name;
    private MetricComponentTypeDTO metricComponentType;

    private Long metric_id;

}
