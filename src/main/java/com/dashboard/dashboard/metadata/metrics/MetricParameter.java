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
    private Set<MetricParameterValue> values;
}
