package com.dashboard.dashboard.metadata.mapper;

import com.dashboard.dashboard.metadata.dto.MetricComponentDTO;
import com.dashboard.dashboard.metadata.dto.MetricComponentTypeDTO;
import com.dashboard.dashboard.metadata.dto.MetricDTO;
import com.dashboard.dashboard.metadata.metrics.Metric;
import com.dashboard.dashboard.metadata.metrics.MetricComponent;
import com.dashboard.dashboard.metadata.metrics.MetricComponentType;
import com.dashboard.dashboard.metadata.repositories.MetricRepository;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Objects;

@Component
public class MetricComponentMapper {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private MetricRepository metricRepository;

    public MetricComponentDTO toDTO(MetricComponent entity) {
        return Objects.isNull(entity) ? null : mapper.map(entity, MetricComponentDTO.class);
    }

    public MetricComponent toEntity(MetricComponentDTO dto) {
        return Objects.isNull(dto) ? null : mapper.map(dto, MetricComponent.class);
    }

    @PostConstruct
    public void setupMapper() {
        mapper.createTypeMap(MetricComponent.class, MetricComponentDTO.class)
                .addMappings(m -> m.skip(MetricComponentDTO::setMetric_id)).setPostConverter(toDtoConverter());

        mapper.createTypeMap(MetricComponentDTO.class, MetricComponent.class)
                .addMappings(m -> m.skip(MetricComponent::setMetric)).setPostConverter(toEntityConverter());
    }

    public Converter<MetricComponentDTO, MetricComponent> toEntityConverter() {
        return context -> {
            MetricComponentDTO source = context.getSource();
            MetricComponent destination = context.getDestination();
            mapSpecificFields(source, destination);
            return context.getDestination();
        };
    }


    public Converter<MetricComponent, MetricComponentDTO> toDtoConverter() {
        return context -> {
            MetricComponent source = context.getSource();
            MetricComponentDTO destination = context.getDestination();
            mapSpecificFields(source, destination);
            return context.getDestination();
        };
    }

    public void mapSpecificFields(MetricComponentDTO source, MetricComponent destination) {
        destination.setMetric(metricRepository.findById(source.getMetric_id()).orElse(null));
    }

    public void mapSpecificFields(MetricComponent source, MetricComponentDTO destination) {
        destination.setMetric_id(Objects.isNull(source) || Objects.isNull(source.getId())
                ? null : !Objects.isNull(source.getMetric()) ? source.getMetric().getId() : null);
    }


}
