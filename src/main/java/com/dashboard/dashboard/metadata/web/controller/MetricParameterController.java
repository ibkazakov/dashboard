package com.dashboard.dashboard.metadata.web.controller;

import com.dashboard.dashboard.metadata.web.dto.MetricParameterDTO;
import com.dashboard.dashboard.metadata.web.dto.MetricParameterValueDTO;
import com.dashboard.dashboard.metadata.web.dto.mapper.MetricParameterMapper;
import com.dashboard.dashboard.metadata.web.dto.mapper.MetricParameterValueMapper;
import com.dashboard.dashboard.metadata.dao.entity.Metric;
import com.dashboard.dashboard.metadata.dao.entity.MetricParameter;
import com.dashboard.dashboard.metadata.dao.entity.MetricParameterValue;
import com.dashboard.dashboard.metadata.service.MetricParameterService;
import com.dashboard.dashboard.metadata.service.MetricParameterValueService;
import com.dashboard.dashboard.metadata.service.MetricService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@RestController
public class MetricParameterController {
    @Autowired
    private MetricParameterMapper parameterMapper;

    @Autowired
    private MetricParameterService metricParameterService;

    @Autowired
    private MetricParameterValueMapper valueMapper;

    @Autowired
    private MetricParameterValueService metricParameterValueService;

    @Autowired
    private MetricService metricService;

    @GetMapping("qmetrics/{id}/parameters")
    public List<MetricParameterDTO> getMetricParameters(@PathVariable Long id) {
        List<MetricParameterDTO> parameterDTOList = new ArrayList<>();
        metricParameterService.allParameters().forEach(new Consumer<MetricParameter>() {
            @Override
            public void accept(MetricParameter parameter) {
                parameterDTOList.add(parameterMapper.toDTO(parameter));
            }
        });
        return parameterDTOList;
    }

    @DeleteMapping("qmetrics/parameters/{parameter_id}")
    public void deleteParameterById(@PathVariable Long parameter_id) {
        metricParameterService.deleteParameterById(parameter_id);
    }


    @PostMapping("qmetrics/{id}/parameters")
    public MetricParameterDTO createMetricParameter(@PathVariable Long id,
                                                    @RequestParam MetricParameterDTO metricParameterDTO) {
        MetricParameter parameter = parameterMapper.toEntity(metricParameterDTO);
        Metric boundMetric = metricService.getMetricById(id);
        parameter.setMetric(boundMetric);
        metricParameterService.createParameter(parameter);
        return parameterMapper.toDTO(parameter);
    }

    @PutMapping("qmetrics/parameters/{parameter_id}")
    public MetricParameterDTO updateMetricParameter(MetricParameterDTO parameterDTO) {
        Long id = parameterDTO.getId();
        if (id == null) {
            return null;
        }
        if (!(metricParameterService.isParameterPresent(id))) {
            return null;
        }
        MetricParameter updated = metricParameterService.updateParameter(
                parameterMapper.toEntity(parameterDTO));
        return parameterMapper.toDTO(updated);
    }

    @GetMapping("qmetrics/parameters/{parameter_id}/values")
    public List<MetricParameterValueDTO> getParameterValues(
            @PathVariable Long parameter_id) {
        List<MetricParameterValueDTO> valueDTOList = new ArrayList<>();
        metricParameterValueService.getMetricParameterValues(parameter_id)
                .forEach(new Consumer<MetricParameterValue>() {
                    @Override
                    public void accept(MetricParameterValue metricParameterValue) {
                        valueDTOList.add(valueMapper.toDTO(metricParameterValue));
                    }
                });
        return valueDTOList;
    }

    @PostMapping("qmetrics/parameters/{parameter_id}/values")
    public MetricParameterValueDTO createParameterValue(
            @PathVariable Long parameter_id,
            @RequestParam MetricParameterValueDTO valueDTO) {
        MetricParameterValue value = valueMapper.toEntity(valueDTO);
        MetricParameter boundParameter = metricParameterService.getParameterById(parameter_id);
        value.setParameter(boundParameter);
        metricParameterValueService.createValue(value);
        return valueMapper.toDTO(value);
    }

    @DeleteMapping("qmetrics/parameters/values/{value_id}")
    public void deleteParameterValueById(Long value_id) {
        metricParameterValueService.deleteValueById(value_id);
    }
}

