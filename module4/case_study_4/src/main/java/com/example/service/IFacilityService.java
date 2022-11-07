package com.example.service;

import com.example.model.Facility;
import com.example.model.FacilityType;
import com.example.model.RentType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IFacilityService {
    Page<Facility> search(String nameSearch, String facilityType, Pageable pageable);

    List<FacilityType> findAllFacilityType();

    List<RentType> findAllRentType();

    void save(Facility facility);

    FacilityType findByIdFacilityType(int facilityType);

    Facility findFacilityByID(int id);

    void delete(int id);
}

