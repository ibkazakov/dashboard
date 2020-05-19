package com.dashboard.dashboard.metadata.controller;

import com.dashboard.dashboard.metadata.dto.MetricDTO;
import com.dashboard.dashboard.metadata.mapper.MetricMapper;
import com.dashboard.dashboard.metadata.metrics.Metric;
import com.dashboard.dashboard.metadata.metrics.MetricComponent;
import com.dashboard.dashboard.metadata.metrics.MetricParameter;
import com.dashboard.dashboard.metadata.service.MetricService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("metric")
public class MetricController {
    @Autowired
    private MetricMapper mapper;

    @Autowired
    private MetricService metricService;

    @PostMapping("create")
    public MetricDTO create(String name, boolean hasDatasource) {
        return mapper.toDTO(metricService.createMetric(name, hasDatasource));
    }

    @GetMapping("allMetrics")
    public Set<MetricDTO> allMetric() {
        Set<MetricDTO> dtos = new HashSet<>();
        Set<Metric> metricSet = metricService.allMetrics();
        for(Metric metric : metricSet) {
            dtos.add(mapper.toDTO(metric));
        }
        return dtos;
    }

    @PutMapping("addParameter")
    public void addParameter(Long id, Long parameter_id) {
        metricService.addParameter(id, parameter_id);
    }

    @PutMapping("addComponent")
    public void addComponent(Long id, Long component_id) {
        metricService.addComponent(id, component_id);
    }

    @PutMapping("removeParameter")
    public void removeParameter(Long id, Long parameter_id) {
        metricService.removeParameter(id, parameter_id);
    }

    @PutMapping("removeComponent")
    public void removeComponent(Long component_id) {
        metricService.removeComponent(component_id);
    }

    @DeleteMapping("delete")
    public void delete(Long id) {
        metricService.deleteMetricById(id);
    }


}
