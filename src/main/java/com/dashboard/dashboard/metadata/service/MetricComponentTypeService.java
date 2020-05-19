package com.dashboard.dashboard.metadata.service;

import com.dashboard.dashboard.metadata.metrics.MetricComponentType;
import com.dashboard.dashboard.metadata.repositories.MetricComponentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.function.Consumer;

@Service
public class MetricComponentTypeService {
    @Autowired
    private MetricComponentTypeRepository
            metricComponentTypeRepository;


    public MetricComponentType createType(String name) {
        MetricComponentType componentType = new MetricComponentType();
        componentType.setName(name);
        String ident = UUID.randomUUID().toString();
        componentType.setIdent(ident);
        metricComponentTypeRepository.save(componentType);
        return componentType;
    }

    public Set<MetricComponentType> allTypes() {
        Set<MetricComponentType> componentTypeSet
                = new HashSet<>();
        metricComponentTypeRepository.findAll().forEach(new Consumer<MetricComponentType>() {
            @Override
            public void accept(MetricComponentType metricComponentType) {
                componentTypeSet.add(metricComponentType);
            }
        });
        return componentTypeSet;
    }

    public void deleteType(Long id) {
        metricComponentTypeRepository.deleteById(id);
    }

    public MetricComponentType getTypeById(Long id) {
        return metricComponentTypeRepository.findById(id).get();
    }
}
