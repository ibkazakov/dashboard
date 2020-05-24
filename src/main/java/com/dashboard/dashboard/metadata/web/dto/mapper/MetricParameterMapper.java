package com.dashboard.dashboard.metadata.web.dto.mapper;

import com.dashboard.dashboard.metadata.web.dto.MetricParameterDTO;
import com.dashboard.dashboard.metadata.dao.entity.MetricParameter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class MetricParameterMapper {
    @Autowired
    private ModelMapper mapper;


    public MetricParameterDTO toDTO(MetricParameter entity) {
        return Objects.isNull(entity) ? null : mapper.map(entity, MetricParameterDTO.class);
    }

    public MetricParameter toEntity(MetricParameterDTO dto) {
        return Objects.isNull(dto) ? null : mapper.map(dto, MetricParameter.class);
    }

}
