package com.dashboard.dashboard.example_mapping;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class ParameterValue {
    @Id
    @GeneratedValue
    private Long id;

    private Long parameter_id;

    private int value;

    private String description;

}
