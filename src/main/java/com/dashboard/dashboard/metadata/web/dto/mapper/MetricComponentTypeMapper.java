package com.dashboard.dashboard.metadata.web.dto.mapper;

import com.dashboard.dashboard.metadata.web.dto.MetricComponentTypeDTO;
import com.dashboard.dashboard.metadata.dao.entity.MetricComponentType;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class MetricComponentTypeMapper {
    @Autowired
    private ModelMapper mapper;

    public MetricComponentTypeDTO toDTO(MetricComponentType entity) {
        return Objects.isNull(entity) ? null : mapper.map(entity, MetricComponentTypeDTO.class);
    }

    public MetricComponentType toEntity(MetricComponentTypeDTO dto) {
        return Objects.isNull(dto) ? null : mapper.map(dto, MetricComponentType.class);
    }
}
