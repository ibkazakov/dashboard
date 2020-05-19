package com.dashboard.dashboard.metadata.metrics;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

// the table of the all possible values
@Entity
@Getter
@Setter
@NoArgsConstructor
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
}
