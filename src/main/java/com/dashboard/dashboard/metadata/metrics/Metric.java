package com.dashboard.dashboard.metadata.metrics;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
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

    @OneToMany(mappedBy = "metric", cascade = CascadeType.ALL)
    private Set<MetricParameter> parameters;

}
