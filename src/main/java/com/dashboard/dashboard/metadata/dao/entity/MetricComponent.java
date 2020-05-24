package com.dashboard.dashboard.metadata.dao.entity;

import javax.persistence.*;

@Entity
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

    public MetricComponent() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdent() {
        return ident;
    }

    public void setIdent(String ident) {
        this.ident = ident;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MetricComponentType getMetricComponentType() {
        return metricComponentType;
    }

    public void setMetricComponentType(MetricComponentType metricComponentType) {
        this.metricComponentType = metricComponentType;
    }

    public Metric getMetric() {
        return metric;
    }

    public void setMetric(Metric metric) {
        this.metric = metric;
    }
}
