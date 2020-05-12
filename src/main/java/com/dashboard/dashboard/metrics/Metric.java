package com.dashboard.dashboard.metrics;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class Metric {
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true, nullable = false, updatable = false)
    private String ident;

    private String name;

    private boolean hasDatasource;

    @OneToMany(mappedBy = "metric", cascade = CascadeType.ALL)
    private Set<MetricComponent> components;

}
