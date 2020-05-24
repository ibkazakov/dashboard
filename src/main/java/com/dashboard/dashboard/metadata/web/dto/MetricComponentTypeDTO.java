package com.dashboard.dashboard.metadata.web.dto;



public class MetricComponentTypeDTO {
    private Long id;
    private String ident;
    private String name;

    public MetricComponentTypeDTO() {
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
}
