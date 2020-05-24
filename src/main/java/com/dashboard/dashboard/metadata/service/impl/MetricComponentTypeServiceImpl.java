package com.dashboard.dashboard.metadata.service.impl;

import com.dashboard.dashboard.metadata.dao.entity.MetricComponentType;
import com.dashboard.dashboard.metadata.dao.repository.MetricComponentTypeRepository;
import com.dashboard.dashboard.metadata.service.MetricComponentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Consumer;

@Service
public class MetricComponentTypeServiceImpl implements MetricComponentTypeService {
    @Autowired
    private MetricComponentTypeRepository
            metricComponentTypeRepository;


    @Override
    public MetricComponentType createType(MetricComponentType componentType) {
        String ident = UUID.randomUUID().toString();
        componentType.setIdent(ident);
        metricComponentTypeRepository.save(componentType);
        return componentType;
    }

    @Override
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

    @Override
    public void deleteTypeById(Long id) {
        metricComponentTypeRepository.deleteById(id);
    }

    @Override
    public MetricComponentType getTypeById(Long id) {
        return metricComponentTypeRepository.findById(id).get();
    }
}
