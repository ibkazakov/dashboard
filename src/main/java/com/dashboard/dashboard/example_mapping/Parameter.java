package com.dashboard.dashboard.example_mapping;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Parameter {
    @Id
    @GeneratedValue
    private Long id;
    
    private int value;
}
