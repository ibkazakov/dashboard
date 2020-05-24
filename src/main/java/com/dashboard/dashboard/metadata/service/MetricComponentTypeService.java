package com.dashboard.dashboard.metadata.service;

import com.dashboard.dashboard.metadata.dao.entity.MetricComponentType;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;

public interface MetricComponentTypeService {
    MetricComponentType createType(MetricComponentType componentType);

    List<MetricComponentType> getAllTypes();

    void deleteTypeById(Long id);

    MetricComponentType getTypeById(Long id);
}
