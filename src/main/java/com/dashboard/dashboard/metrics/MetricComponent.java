package com.dashboard.dashboard.metrics;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class MetricComponent {
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true, nullable = false, updatable = false)
    private String ident;

    private String name;

    @ManyToOne
    @JoinColumn(name = "type_id", nullable = false)
    private MetricComponentType metricComponentType;

    @ManyToOne
    @JoinColumn(name = "metric_id", nullable = false)
    private Metric metric;
}
