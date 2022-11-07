package com.example.service.impl;

import com.example.model.Facility;
import com.example.model.FacilityType;
import com.example.model.RentType;
import com.example.repository.FacilityRepository;
import com.example.repository.FacilityTypeRepository;
import com.example.repository.RentTypeRepository;
import com.example.service.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacilityService implements IFacilityService {
    @Autowired
    FacilityRepository facilityRepository;

    @Autowired
    FacilityTypeRepository facilityTypeRepository;

    @Autowired
    RentTypeRepository rentTypeRepository;

    @Override
    public Page<Facility> search(String nameSearch, String facilityType, Pageable pageable) {
        return facilityRepository.search(nameSearch, facilityType, pageable);
    }

    @Override
    public List<FacilityType> findAllFacilityType() {
        return facilityTypeRepository.findAll();
    }

    @Override
    public List<RentType> findAllRentType() {
        return rentTypeRepository.findAll();
    }

    @Override
    public void save(Facility facility) {
        facilityRepository.save(facility);
    }

    @Override
    public FacilityType findByIdFacilityType(int facilityType) {
        return facilityTypeRepository.findById(facilityType).orElse(null);
    }

    @Override
    public Facility findFacilityByID(int id) {
        return facilityRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        facilityRepository.delete(id);
    }
}
