package com.dashboard.dashboard.metadata.service;

import com.dashboard.dashboard.metadata.dao.entity.MetricComponentType;
import com.dashboard.dashboard.metadata.dao.repository.MetricComponentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Consumer;

@Service
public class MetricComponentTypeService {
    @Autowired
    private MetricComponentTypeRepository
            metricComponentTypeRepository;


    public MetricComponentType createType(MetricComponentType componentType) {
        String ident = UUID.randomUUID().toString();
        componentType.setIdent(ident);
        metricComponentTypeRepository.save(componentType);
        return componentType;
    }

    public List<MetricComponentType> getAllTypes() {
        List<MetricComponentType> componentTypeList
                = new ArrayList<>();
        metricComponentTypeRepository.findAll().forEach(new Consumer<MetricComponentType>() {
            @Override
            public void accept(MetricComponentType metricComponentType) {
                componentTypeList.add(metricComponentType);
            }
        });
        return componentTypeList;
    }

    public void deleteTypeById(Long id) {
        metricComponentTypeRepository.deleteById(id);
    }

    public MetricComponentType getTypeById(Long id) {
        return metricComponentTypeRepository.findById(id).get();
    }
}
