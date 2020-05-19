package com.dashboard.dashboard.metadata.dto;

import com.dashboard.dashboard.metadata.metrics.MetricParameter;
import lombok.Data;

import javax.persistence.*;

@Data
public class MetricParameterValueDTO {
    private Long id;
    private String ident;
    private String name;
    private String description;
    private boolean isDefault;

    private Long parameter_id;
}
