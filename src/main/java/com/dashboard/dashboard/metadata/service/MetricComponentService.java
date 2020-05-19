package com.dashboard.dashboard.metadata.service;

import com.dashboard.dashboard.metadata.dto.MetricComponentDTO;
import com.dashboard.dashboard.metadata.mapper.MetricComponentMapper;
import com.dashboard.dashboard.metadata.metrics.MetricComponent;
import com.dashboard.dashboard.metadata.metrics.MetricComponentType;
import com.dashboard.dashboard.metadata.repositories.MetricComponentRepository;
import com.dashboard.dashboard.metadata.repositories.MetricRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.function.Consumer;

@Service
public class MetricComponentService {
    @Autowired
    private MetricComponentRepository metricComponentRepository;

    @Autowired
    private MetricComponentTypeService metricComponentTypeService;


    public MetricComponent createComponent(String name,
                                              Long type_id) {
        MetricComponent metricComponent
                = new MetricComponent();
        metricComponent.setName(name);
        String ident = UUID.randomUUID().toString();
        metricComponent.setIdent(ident);

        MetricComponentType type =
                metricComponentTypeService.getTypeById(type_id);


        metricComponent.setMetricComponentType(type);
        metricComponentRepository.save(metricComponent);
        return metricComponent;
    }

    public MetricComponent getComponentById(Long id) {
        return metricComponentRepository.findById(id).get();
    }

    public Set<MetricComponent> allComponents() {
        Set<MetricComponent> components = new HashSet<>();
        metricComponentRepository.findAll().forEach(new Consumer<MetricComponent>() {
            @Override
            public void accept(MetricComponent component) {
                components.add(component);
            }
        });
        return components;
    }

    public void updateComponent(MetricComponent component) {
        metricComponentRepository.save(component);
    }

    public void deleteComponent(Long id) {
        metricComponentRepository.deleteById(id);
    }
}
