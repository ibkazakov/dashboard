package com.dashboard.dashboard.metadata.dao.entity;


import javax.persistence.*;
import java.util.List;

@Entity
public class MetricParameter {
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true, nullable = false, updatable = false)
    private String ident;

    private String name;

    private boolean isDefault;

    @ManyToOne
    @JoinColumn(name = "metric_id")
    private Metric metric;

    @OneToMany(mappedBy = "parameter", cascade = CascadeType.ALL)
    private List<MetricParameterValue> values;

    public MetricParameter() {
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

    public boolean isDefault() {
        return isDefault;
    }

    public void setDefault(boolean aDefault) {
        isDefault = aDefault;
    }

    public Metric getMetric() {
        return metric;
    }

    public void setMetric(Metric metric) {
        this.metric = metric;
    }

    public List<MetricParameterValue> getValues() {
        return values;
    }

    public void setValues(List<MetricParameterValue> values) {
        this.values = values;
    }
}
