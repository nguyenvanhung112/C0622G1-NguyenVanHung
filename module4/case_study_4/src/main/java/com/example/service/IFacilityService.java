package com.example.service;

import com.example.model.Facility;
import com.example.model.FacilityType;
import com.example.model.RentType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IFacilityService {
    Page<Facility> search(String nameSearch, String facilityType, Pageable pageable);

    List<FacilityType> findAllFacilityType();

    List<RentType> findAllRentType();

    void save(Facility facility);
}

