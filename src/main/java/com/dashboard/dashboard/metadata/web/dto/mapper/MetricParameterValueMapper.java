package com.dashboard.dashboard.metadata.web.dto.mapper;

import com.dashboard.dashboard.metadata.web.dto.MetricParameterValueDTO;
import com.dashboard.dashboard.metadata.dao.entity.MetricParameterValue;
import com.dashboard.dashboard.metadata.dao.repository.MetricParameterRepository;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Objects;

@Component
public class MetricParameterValueMapper {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private MetricParameterRepository metricParameterRepository;

    public MetricParameterValueDTO toDTO(MetricParameterValue  entity) {
        return Objects.isNull(entity) ? null : mapper.map(entity, MetricParameterValueDTO.class);
    }

    public MetricParameterValue toEntity(MetricParameterValueDTO dto) {
        return Objects.isNull(dto) ? null : mapper.map(dto, MetricParameterValue.class);
    }

    @PostConstruct
    public void setupMapper() {
     //   mapper.createTypeMap(MetricParameterValueDTO.class, MetricParameterValue.class)
       //         .addMappings(m -> m.skip(MetricParameterValue::setParameter)).setPostConverter(toDtoConverter());

    //    mapper.createTypeMap(MetricParameterValue.class, MetricParameterValueDTO.class)
     //           .addMappings(m -> m.skip(MetricParameterValueDTO::setParameter_id)).setPostConverter(toEntityConverter());
    }

    public Converter<MetricParameterValue, MetricParameterValueDTO> toEntityConverter() {
        return context -> {
            MetricParameterValue source = context.getSource();
            MetricParameterValueDTO destination = context.getDestination();
            mapSpecificFields(source, destination);
            return context.getDestination();
        };
    }


    public Converter<MetricParameterValueDTO, MetricParameterValue> toDtoConverter() {
        return context -> {
            MetricParameterValueDTO source = context.getSource();
            MetricParameterValue destination = context.getDestination();
            mapSpecificFields(source, destination);
            return context.getDestination();
        };
    }

    public void mapSpecificFields(MetricParameterValueDTO source, MetricParameterValue destination) {
//        destination.setParameter(metricParameterRepository.findById(source.getParameter_id()).orElse(null));
    }

    public void mapSpecificFields(MetricParameterValue source, MetricParameterValueDTO destination) {
  //      destination.setParameter_id(Objects.isNull(source) || Objects.isNull(source.getId())
    //            ? null : !Objects.isNull(source.getParameter()) ?
    //            source.getParameter().getId() : null);
    }
}
