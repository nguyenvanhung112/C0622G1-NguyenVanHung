package com.example.dto;

import com.example.model.FacilityType;
import com.example.model.RentType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Optional;
import java.util.Set;


public class FacilityDTO implements Validator {

    private int id;

    @NotBlank(message = "Not empty")
    private String name;

    private int area;

    private double cost;

    private int maxPeople;
    @NotBlank(message = "Not empty")
    private String standardRoom;
    @NotBlank(message = "Not empty")
    private String descriptionOtherConvenience;

    private double poolArea;

    private int numberFloors;
    @NotBlank(message = "Not empty")
    private String facilityFree;
    private int deleteStatus = 1;
    private RentType rentTypeId;
    private FacilityType facilityTypeId;



    public FacilityDTO() {
    }

    public FacilityDTO(int id, String name, int area, double cost, int maxPeople, String standardRoom, String descriptionOtherConvenience, double poolArea, int numberFloors, String facilityFree, int deleteStatus, RentType rentTypeId, FacilityType facilityTypeId) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.maxPeople = maxPeople;
        this.standardRoom = standardRoom;
        this.descriptionOtherConvenience = descriptionOtherConvenience;
        this.poolArea = poolArea;
        this.numberFloors = numberFloors;
        this.facilityFree = facilityFree;
        this.deleteStatus = deleteStatus;
        this.rentTypeId = rentTypeId;
        this.facilityTypeId = facilityTypeId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionOtherConvenience() {
        return descriptionOtherConvenience;
    }

    public void setDescriptionOtherConvenience(String descriptionOtherConvenience) {
        this.descriptionOtherConvenience = descriptionOtherConvenience;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumberFloors() {
        return numberFloors;
    }

    public void setNumberFloors(int numberFloors) {
        this.numberFloors = numberFloors;
    }

    public String getFacilityFree() {
        return facilityFree;
    }

    public void setFacilityFree(String facilityFree) {
        this.facilityFree = facilityFree;
    }

    public int getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(int deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public RentType getRentTypeId() {
        return rentTypeId;
    }

    public void setRentTypeId(RentType rentTypeId) {
        this.rentTypeId = rentTypeId;
    }

    public FacilityType getFacilityTypeId() {
        return facilityTypeId;
    }

    public void setFacilityTypeId(FacilityType facilityTypeId) {
        this.facilityTypeId = facilityTypeId;
    }


    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        FacilityDTO facilityDTO = (FacilityDTO) target;
        if (!facilityDTO.name.matches("^\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*$")){
            errors.rejectValue("name", "nameFacility.errors", "Name not format");
        }
        if (facilityDTO.area <= 0) {
            errors.rejectValue("area", "area.errors", "Area not format");
        }
        if (facilityDTO.cost <= 0) {
            errors.rejectValue("cost", "cost.errors", "Cost not format");
        }
        if (facilityDTO.maxPeople <= 0) {
            errors.rejectValue("maxPeople", "maxPeople.errors", "Max People not format");
        }
        if (facilityDTO.poolArea <= 0) {
            errors.rejectValue("poolArea", "poolArea.errors", "Pool Area not format");
        }
        if (facilityDTO.numberFloors <= 0) {
            errors.rejectValue("numberFloors", "numberFloors.errors", "Number Floors not format");
        }
    }
}
