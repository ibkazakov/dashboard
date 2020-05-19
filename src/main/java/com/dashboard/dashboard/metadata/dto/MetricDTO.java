package com.dashboard.dashboard.metadata.dto;

import com.dashboard.dashboard.metadata.metrics.MetricComponent;
import com.dashboard.dashboard.metadata.metrics.MetricParameter;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.util.Set;


@Data
public class MetricDTO {
    private Long id;
    private String ident;
    private String name;
    private boolean hasDatasource;

    private Set<MetricComponentDTO> components;

    private Set<MetricParameterDTO> parameters;
}
