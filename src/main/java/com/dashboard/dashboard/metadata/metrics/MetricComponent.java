package com.dashboard.dashboard.metadata.metrics;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
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
    @JoinColumn(name = "metric_id")
    private Metric metric;
}
