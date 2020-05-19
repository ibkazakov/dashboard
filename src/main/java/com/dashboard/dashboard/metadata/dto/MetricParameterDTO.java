package com.dashboard.dashboard.metadata.dto;

import com.dashboard.dashboard.metadata.metrics.Metric;
import com.dashboard.dashboard.metadata.metrics.MetricParameterValue;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
public class MetricParameterDTO {
    private Long id;
    private String ident;
    private String name;
    private boolean isDefault;

    private Long metric_id;

    private Set<MetricParameterValueDTO> values;
}
