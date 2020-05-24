package com.dashboard.dashboard.metadata.web.dto.mapper;

import com.dashboard.dashboard.metadata.web.dto.MetricDTO;
import com.dashboard.dashboard.metadata.dao.entity.Metric;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class MetricMapper {
    @Autowired
    private ModelMapper mapper;

    public MetricDTO toDTO(Metric entity) {
        return Objects.isNull(entity) ? null : mapper.map(entity, MetricDTO.class);
    }

    public Metric toEntity(MetricDTO dto) {
        return Objects.isNull(dto) ? null : mapper.map(dto, Metric.class);
    }


}
