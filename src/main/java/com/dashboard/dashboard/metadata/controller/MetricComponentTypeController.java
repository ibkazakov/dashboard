package com.dashboard.dashboard.metadata.controller;

import com.dashboard.dashboard.metadata.dto.MetricComponentTypeDTO;
import com.dashboard.dashboard.metadata.mapper.MetricComponentTypeMapper;
import com.dashboard.dashboard.metadata.metrics.MetricComponentType;
import com.dashboard.dashboard.metadata.service.MetricComponentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

@RestController
@RequestMapping("metricComponentType")
public class MetricComponentTypeController {
    @Autowired
    private MetricComponentTypeMapper mapper;

    @Autowired
    private MetricComponentTypeService metricComponentTypeService;

    @PostMapping("create")
    public MetricComponentTypeDTO create(String name) {
        return mapper.toDTO(metricComponentTypeService.createType(name));
    }

    @GetMapping("allTypes")
    public Set<MetricComponentTypeDTO> allTypes() {
       Set<MetricComponentTypeDTO> componentTypeDTOS = new HashSet<>();
       metricComponentTypeService.allTypes().forEach(new Consumer<MetricComponentType>() {
           @Override
           public void accept(MetricComponentType metricComponentType) {
               componentTypeDTOS.add(mapper.toDTO(metricComponentType));
           }
       });
       return componentTypeDTOS;
    }

    @GetMapping("getType")
    public MetricComponentTypeDTO getType(Long id) {
        return mapper.toDTO(metricComponentTypeService.getTypeById(id));
    }

    @DeleteMapping("delete")
    public void delete(Long id) {
        metricComponentTypeService.deleteType(id);
    }
}

