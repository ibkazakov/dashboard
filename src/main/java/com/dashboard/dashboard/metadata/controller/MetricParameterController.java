package com.dashboard.dashboard.metadata.controller;

import com.dashboard.dashboard.metadata.dto.MetricParameterDTO;
import com.dashboard.dashboard.metadata.mapper.MetricParameterMapper;
import com.dashboard.dashboard.metadata.metrics.MetricParameter;
import com.dashboard.dashboard.metadata.service.MetricParameterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.function.Consumer;

@RestController
@RequestMapping("metricParameter")
public class MetricParameterController {
    @Autowired
    private MetricParameterMapper mapper;

    @Autowired
    private MetricParameterService metricParameterService;

    @PostMapping("create")
    public MetricParameterDTO create(String name, boolean isDefault) {
        return mapper.toDTO(metricParameterService.createParameter(name, isDefault));
    }

    @GetMapping("getParameter")
    public MetricParameterDTO getParameter(Long id) {
        return mapper.toDTO(metricParameterService.getParameterById(id));
    }

    @GetMapping("allParameters")
    public Set<MetricParameterDTO> allParameters() {
        Set<MetricParameterDTO> metricParameterDTOS = new HashSet<>();
        metricParameterService.allParameters().forEach(new Consumer<MetricParameter>() {
            @Override
            public void accept(MetricParameter parameter) {
                metricParameterDTOS.add(mapper.toDTO(parameter));
            }
        });
        return metricParameterDTOS;
    }

    @DeleteMapping("delete")
    public void delete(Long id) {
        metricParameterService.deleteParameter(id);
    }
}
