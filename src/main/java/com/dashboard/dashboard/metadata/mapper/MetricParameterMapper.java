package com.dashboard.dashboard.metadata.mapper;

import com.dashboard.dashboard.metadata.dto.MetricComponentDTO;
import com.dashboard.dashboard.metadata.dto.MetricComponentTypeDTO;
import com.dashboard.dashboard.metadata.dto.MetricParameterDTO;
import com.dashboard.dashboard.metadata.metrics.MetricComponent;
import com.dashboard.dashboard.metadata.metrics.MetricComponentType;
import com.dashboard.dashboard.metadata.metrics.MetricParameter;
import com.dashboard.dashboard.metadata.repositories.MetricRepository;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Objects;

@Component
public class MetricParameterMapper {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private MetricRepository metricRepository;

    public MetricParameterDTO toDTO(MetricParameter entity) {
        return Objects.isNull(entity) ? null : mapper.map(entity, MetricParameterDTO.class);
    }

    public MetricParameter toEntity(MetricParameterDTO dto) {
        return Objects.isNull(dto) ? null : mapper.map(dto, MetricParameter.class);
    }

    @PostConstruct
    public void setupMapper() {
        mapper.createTypeMap(MetricParameter.class, MetricParameterDTO.class)
                .addMappings(m -> m.skip(MetricParameterDTO::setMetric_id)).setPostConverter(toDtoConverter());

        mapper.createTypeMap(MetricParameterDTO.class, MetricParameter.class)
                .addMappings(m -> m.skip(MetricParameter::setMetric)).setPostConverter(toEntityConverter());
    }

    public Converter<MetricParameterDTO, MetricParameter> toEntityConverter() {
        return context -> {
            MetricParameterDTO source = context.getSource();
            MetricParameter destination = context.getDestination();
            mapSpecificFields(source, destination);
            return context.getDestination();
        };
    }


    public Converter<MetricParameter, MetricParameterDTO> toDtoConverter() {
        return context -> {
            MetricParameter source = context.getSource();
            MetricParameterDTO destination = context.getDestination();
            mapSpecificFields(source, destination);
            return context.getDestination();
        };
    }

    public void mapSpecificFields(MetricParameterDTO source, MetricParameter destination) {
        destination.setMetric(metricRepository.findById(source.getMetric_id()).orElse(null));
    }

    public void mapSpecificFields(MetricParameter source, MetricParameterDTO destination) {
        destination.setMetric_id(Objects.isNull(source) || Objects.isNull(source.getId())
                ? null : !Objects.isNull(source.getMetric()) ?  source.getMetric().getId() : null );
    }
}
