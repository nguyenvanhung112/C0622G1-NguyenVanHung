package com.example.dto;

import com.example.model.ContractDetail;
import com.example.model.Customer;
import com.example.model.Employee.Employee;
import com.example.model.Facility;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

public class ContractDTO implements Validator {

    private int id;
    @NotBlank(message = "Not empty")
    private String dateStart;
    @NotBlank(message = "Not empty")
    private String dateEnd;

    @Min(0)
    @NotNull
    private double deposit;

    private int deleteStatus = 1;

    private Employee employeeId;

    private Customer customerId;

    private Facility facilityId;

    private double totalPrice;

    private Set<ContractDetail> contractDetailSet;

    public ContractDTO() {
    }

    public ContractDTO(int id, String dateStart, String dateEnd, double deposit, int deleteStatus, Employee employeeId, Customer customerId, Facility facilityId, Set<ContractDetail> contractDetailSet) {
        this.id = id;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.deposit = deposit;
        this.deleteStatus = deleteStatus;
        this.employeeId = employeeId;
        this.customerId = customerId;
        this.facilityId = facilityId;
        this.contractDetailSet = contractDetailSet;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public int getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(int deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    public Facility getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(Facility facilityId) {
        this.facilityId = facilityId;
    }

    public Set<ContractDetail> getContractDetailSet() {
        return contractDetailSet;
    }

    public void setContractDetailSet(Set<ContractDetail> contractDetailSet) {
        this.contractDetailSet = contractDetailSet;
    }

    public void getTotalCost() {
        this.totalPrice = this.facilityId.getCost();
        if (this.contractDetailSet != null) {
            for (ContractDetail contractDetail : this.contractDetailSet) {
                this.totalPrice += contractDetail.getQuantity() * contractDetail.getAttachFacilityId().getCost();
            }
        }
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ContractDTO contractDTO = (ContractDTO) target;
    }
}
