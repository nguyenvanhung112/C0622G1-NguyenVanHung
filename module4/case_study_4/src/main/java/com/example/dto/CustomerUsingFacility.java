package com.example.dto;

import com.example.model.ContractDetail;

import java.util.List;

public interface CustomerUsingFacility {
    String getCustomerName();

    String getFacilityList();

    String getStartDay();

    String getEndDay();

    int getCustomerId();
}
