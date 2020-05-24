package com.dashboard.dashboard.metadata.web.controller;

import com.dashboard.dashboard.metadata.service.MetricComponentService;
import com.dashboard.dashboard.metadata.web.dto.MetricComponentDTO;
import com.dashboard.dashboard.metadata.web.dto.mapper.MetricComponentMapper;
import com.dashboard.dashboard.metadata.dao.entity.Metric;
import com.dashboard.dashboard.metadata.dao.entity.MetricComponent;
import com.dashboard.dashboard.metadata.service.impl.MetricServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@RestController
public class MetricComponentController {
    @Autowired
    private MetricComponentMapper componentMapper;

    @Autowired
    private MetricComponentService metricComponentService;

    @Autowired
    private MetricServiceImpl metricService;

    @GetMapping("qmetrics/{id}/components")
    public List<MetricComponentDTO> getMetricComponents(@PathVariable Long id) {
        List<MetricComponentDTO> componentDTOList = new ArrayList<>();
        metricComponentService.getMetricComponents(id).forEach(new Consumer<MetricComponent>() {
            @Override
            public void accept(MetricComponent component) {
                componentDTOList.add(componentMapper.toDTO(component));
            }
        });
        return componentDTOList;
    }

    @DeleteMapping("qmetrics/components/{component_id}")
    public void deleteComponentById(@PathVariable Long component_id) {
        metricComponentService.deleteComponentById(component_id);
    }

    @PostMapping("qmetrics/{id}/components")
    public MetricComponentDTO createMetricComponent(@PathVariable Long id,
                                                    @RequestParam MetricComponentDTO metricComponentDTO) {
        MetricComponent component = componentMapper.toEntity(metricComponentDTO);
        Metric boundMetric = metricService.getMetricById(id);
        component.setMetric(boundMetric);
        metricComponentService.createComponent(component);
        return componentMapper.toDTO(component);
    }

    @PutMapping("qmetrics/components/{component_id}")
    public MetricComponentDTO updateMetricComponent(@PathVariable Long component_id,
                                                    MetricComponentDTO componentDTO) {
        Long id = componentDTO.getId();
        if (id == null) {
            return null;
        }
        if (!metricComponentService.isComponentPresent(component_id)) {
            return null;
        }
        MetricComponent updated = metricComponentService.updateComponent(componentMapper.toEntity(componentDTO));
        return componentMapper.toDTO(updated);
    }


}
