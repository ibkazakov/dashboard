package com.dashboard.dashboard.metadata.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
public class MetricComponentTypeDTO {
    private Long id;
    private String ident;
    private String name;
}
