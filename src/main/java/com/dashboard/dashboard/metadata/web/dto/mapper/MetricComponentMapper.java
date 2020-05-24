package com.dashboard.dashboard.metadata.web.dto.mapper;

import com.dashboard.dashboard.metadata.web.dto.MetricComponentDTO;
import com.dashboard.dashboard.metadata.dao.entity.MetricComponent;
import com.dashboard.dashboard.metadata.dao.entity.MetricComponentType;
import com.dashboard.dashboard.metadata.dao.repository.MetricComponentTypeRepository;
import com.dashboard.dashboard.metadata.dao.repository.MetricRepository;
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

    @Autowired
    private MetricComponentTypeRepository metricComponentTypeRepository;

    public MetricComponentDTO toDTO(MetricComponent entity) {
        return Objects.isNull(entity) ? null : mapper.map(entity, MetricComponentDTO.class);
    }

    public MetricComponent toEntity(MetricComponentDTO dto) {
        return Objects.isNull(dto) ? null : mapper.map(dto, MetricComponent.class);
    }

    @PostConstruct
    public void setupMapper() {
        mapper.createTypeMap(MetricComponentDTO.class, MetricComponent.class)
                .addMappings(m -> m.skip(MetricComponent::setMetric)).setPostConverter(toEntityConverter());

        mapper.createTypeMap(MetricComponent.class, MetricComponentDTO.class)
                .addMappings(m -> m.skip(MetricComponentDTO::setTypeId)).setPostConverter(toDtoConverter());
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
        MetricComponentType componentType = metricComponentTypeRepository.getOne(source.getId());
        destination.setMetricComponentType(componentType);
    }

    public void mapSpecificFields(MetricComponent source, MetricComponentDTO destination) {
        destination.setTypeId(source.getMetricComponentType().getId());
    }


}
