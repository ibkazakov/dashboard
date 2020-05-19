package com.dashboard.dashboard.metadata.controller;

import com.dashboard.dashboard.metadata.dto.MetricComponentDTO;
import com.dashboard.dashboard.metadata.mapper.MetricComponentMapper;
import com.dashboard.dashboard.metadata.metrics.MetricComponent;
import com.dashboard.dashboard.metadata.metrics.MetricComponentType;
import com.dashboard.dashboard.metadata.service.MetricComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.function.Consumer;

@RestController
@RequestMapping("metricComponent")
public class MetricComponentController  {

    @Autowired
    private MetricComponentMapper mapper;

    @Autowired
    private MetricComponentService metricComponentService;

    @PostMapping("create")
    public MetricComponentDTO create(String name, Long type_id) {
        return mapper.toDTO(metricComponentService.createComponent(name, type_id));
    }

    @GetMapping("getComponent")
    public MetricComponentDTO getComponentById(Long id) {
        return mapper.toDTO(metricComponentService.getComponentById(id));
    }

    @GetMapping("allComponents")
    public Set<MetricComponentDTO> allComponents() {
        Set<MetricComponentDTO> componentDTOS = new HashSet<>();
        metricComponentService.allComponents().forEach(new Consumer<MetricComponent>() {
            @Override
            public void accept(MetricComponent component) {
                componentDTOS.add(mapper.toDTO(component));
            }
        });
        return componentDTOS;
    }


    @DeleteMapping("delete")
    public void deleteComponent(Long id) {
        metricComponentService.deleteComponent(id);
    }
}
