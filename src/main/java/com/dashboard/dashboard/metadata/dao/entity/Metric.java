package com.dashboard.dashboard.metadata.dao.entity;


import javax.persistence.*;
import java.util.List;

@Entity
public class Metric {
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true, nullable = false, updatable = false)
    private String ident;

    private String name;

    private boolean hasDatasource;

    @OneToMany(mappedBy = "metric", cascade = CascadeType.ALL)
    private List<MetricComponent> components;

    @OneToMany(mappedBy = "metric", cascade = CascadeType.ALL)
    private List<MetricParameter> parameters;

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

    public boolean isHasDatasource() {
        return hasDatasource;
    }

    public void setHasDatasource(boolean hasDatasource) {
        this.hasDatasource = hasDatasource;
    }

    public List<MetricComponent> getComponents() {
        return components;
    }

    public void setComponents(List<MetricComponent> components) {
        this.components = components;
    }

    public List<MetricParameter> getParameters() {
        return parameters;
    }

    public void setParameters(List<MetricParameter> parameters) {
        this.parameters = parameters;
    }

    public Metric() {
    }
}
