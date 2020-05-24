package com.dashboard.dashboard.metadata.dao.entity;


import javax.persistence.*;

// the table of the all possible values
@Entity
public class MetricParameterValue {
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true, nullable = false, updatable = false)
    private String ident;

    private String name;

    private String description;

    private boolean isDefault;

    @ManyToOne
    @JoinColumn(name = "parameter_id", nullable = false)
    private MetricParameter parameter;


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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public void setDefault(boolean aDefault) {
        isDefault = aDefault;
    }

    public MetricParameter getParameter() {
        return parameter;
    }

    public void setParameter(MetricParameter parameter) {
        this.parameter = parameter;
    }
}
