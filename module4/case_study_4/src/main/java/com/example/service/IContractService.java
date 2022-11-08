package com.example.service;

import com.example.model.AttachFacility;
import com.example.model.Contract;
import com.example.model.ContractDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface IContractService {
    Page<Contract> findAll(Pageable pageable);

    List<AttachFacility> getAttachFacilities();

    List<ContractDetail> getListContractDetail();

    List<ContractDetail> getContractDetail(int id);

    Contract findById(int contractId);

    AttachFacility findAttachFacilityId(int attachId);

    void saveContractDetail(ContractDetail contractDetail);

    void save(Contract contract);

    ContractDetail findContractDetailId(int attachId, int contractId);
}
