package com.dashboard.dashboard.metadata.web.controller;

import com.dashboard.dashboard.metadata.service.MetricService;
import com.dashboard.dashboard.metadata.web.dto.MetricDTO;
import com.dashboard.dashboard.metadata.web.dto.mapper.MetricMapper;
import com.dashboard.dashboard.metadata.dao.entity.Metric;
import com.dashboard.dashboard.metadata.service.impl.MetricServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@RestController
public class MetricController {

    @Autowired
    private MetricService metricService;

    @Autowired
    private MetricMapper metricMapper;

    @GetMapping("qmetrics/{id}")
    public MetricDTO getMetricById(@PathVariable Long id) {
        return metricMapper.toDTO(metricService.getMetricById(id));
    }

    @GetMapping("qmetrics")
    public List<MetricDTO> getAllMetrics() {
        List<MetricDTO> metricDTOS = new ArrayList<>();
        metricService.getAllMetrics().forEach(new Consumer<Metric>() {
            @Override
            public void accept(Metric metric) {
                metricDTOS.add(metricMapper.toDTO(metric));
            }
        });
        return metricDTOS;
    }

    @DeleteMapping("qmetrics/{id}")
    public void deleteMetricById(@PathVariable Long id) {
        metricService.deleteMetricById(id);
    }

    @PostMapping("qmetrics")
    public MetricDTO createMetric(MetricDTO metricDTO) {
       Metric metric = metricMapper.toEntity(metricDTO);
       metricService.createMetric(metric);
       return metricMapper.toDTO(metric);
    }

    @PutMapping("qmetrics")
    public MetricDTO updateMetric(MetricDTO metricDTO) {
        Long id = metricDTO.getId();
        if (id == null) {
            return null;
        }
        if (!(metricService.isMetricPresent(id))) {
            return null;
        }

        Metric updated = metricService.updateMetric(metricMapper.toEntity(metricDTO));
        return metricMapper.toDTO(updated);
    }

}
