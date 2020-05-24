package com.dashboard.dashboard.metadata.web.dto;


public class MetricDTO {
    private Long id;
    private String ident;
    private String name;
    private boolean hasDatasource;


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

}
