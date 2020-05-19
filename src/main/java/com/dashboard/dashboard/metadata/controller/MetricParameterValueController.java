package com.dashboard.dashboard.metadata.controller;

import com.dashboard.dashboard.metadata.dto.MetricParameterValueDTO;
import com.dashboard.dashboard.metadata.mapper.MetricParameterValueMapper;
import com.dashboard.dashboard.metadata.metrics.MetricParameterValue;
import com.dashboard.dashboard.metadata.service.MetricParameterValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

@RestController
@RequestMapping("metricParameterValue")
public class MetricParameterValueController {
    @Autowired
    private MetricParameterValueMapper mapper;

    @Autowired
    private MetricParameterValueService metricParameterValueService;

    @PostMapping("create")
    public MetricParameterValueDTO createValue(String name, String description,
                                               boolean isDefault, Long parameter_id) {

        return mapper.toDTO(metricParameterValueService.createValue(name, description, isDefault, parameter_id));
    }

    @GetMapping("allValues")
    public Set<MetricParameterValueDTO> allValues() {
        Set<MetricParameterValueDTO> parameterValueDTOS = new HashSet<>();
        metricParameterValueService.allValues().forEach(new Consumer<MetricParameterValue>() {
            @Override
            public void accept(MetricParameterValue metricParameterValue) {
                parameterValueDTOS.add(mapper.toDTO(metricParameterValue));
            }
        });
        return parameterValueDTOS;
    }

    @DeleteMapping("delete")
    public void deleteValue(Long id) {
        metricParameterValueService.deleteValue(id);
    }
}
