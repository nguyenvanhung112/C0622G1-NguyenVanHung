package com.example.repository;

import com.example.model.FacilityType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository
public interface FacilityTypeRepository extends JpaRepository<FacilityType,Integer> {
}
