package com.dashboard.dashboard.metrics;

import lombok.Data;

import javax.persistence.*;

// the table of the all possible values
@Entity
@Data
public class MetricParameterValue {
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true, nullable = false, updatable = false)
    private String ident;

    private String name;

    private Long parameter_id;

    private int value;

    private String description;
}
