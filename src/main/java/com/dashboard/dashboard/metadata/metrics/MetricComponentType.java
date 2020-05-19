package com.dashboard.dashboard.metadata.metrics;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class MetricComponentType {
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true, nullable = false, updatable = false)
    private String ident;

    private String name;
}
