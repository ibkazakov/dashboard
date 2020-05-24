package com.dashboard.dashboard.metadata.web.controller;

import com.dashboard.dashboard.metadata.web.dto.MetricComponentTypeDTO;
import com.dashboard.dashboard.metadata.web.dto.mapper.MetricComponentTypeMapper;
import com.dashboard.dashboard.metadata.dao.entity.MetricComponentType;
import com.dashboard.dashboard.metadata.service.MetricComponentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@RestController
@RequestMapping("/qcomponent-type-service")
public class MetricComponentTypeController {

    @Autowired
    private MetricComponentTypeService metricComponentTypeService;

    @Autowired
    private MetricComponentTypeMapper mapper;

    @PostMapping("/qcomponent-type")
    public MetricComponentTypeDTO
    createType(MetricComponentTypeDTO metricComponentTypeDTO) {
        MetricComponentType componentType =
                mapper.toEntity(metricComponentTypeDTO);
        metricComponentTypeService.createType(componentType);
        return mapper.toDTO(componentType);
    }

    @GetMapping("/qcomponent-type/{id}")
    public MetricComponentTypeDTO
    getTypeById(@PathVariable Long id) {
        return mapper.toDTO(metricComponentTypeService.getTypeById(id));
    }

    @GetMapping("/qcomponent-type")
    public List<MetricComponentTypeDTO> getTypes() {
        List<MetricComponentTypeDTO> componentTypeDTOS = new ArrayList<>();
        metricComponentTypeService.getAllTypes().forEach(new Consumer<MetricComponentType>() {
            @Override
            public void accept(MetricComponentType componentType) {
                componentTypeDTOS.add(mapper.toDTO(componentType));
            }
        });
        return componentTypeDTOS;
    }

    @DeleteMapping("/qcomponent-type/{id}")
    public void deleteTypeById(@PathVariable Long id) {
        metricComponentTypeService.deleteTypeById(id);
    }
}
