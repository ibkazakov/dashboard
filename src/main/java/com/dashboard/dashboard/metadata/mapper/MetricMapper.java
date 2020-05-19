package com.dashboard.dashboard.metadata.mapper;

import com.dashboard.dashboard.metadata.dto.MetricComponentTypeDTO;
import com.dashboard.dashboard.metadata.dto.MetricDTO;
import com.dashboard.dashboard.metadata.metrics.Metric;
import com.dashboard.dashboard.metadata.metrics.MetricComponentType;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
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
