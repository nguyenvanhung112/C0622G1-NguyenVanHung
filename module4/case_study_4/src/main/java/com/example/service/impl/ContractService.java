package com.example.service.impl;

import com.example.model.AttachFacility;
import com.example.model.Contract;
import com.example.model.ContractDetail;
import com.example.repository.AttachRepository;
import com.example.repository.ContractDetailRepository;
import com.example.repository.ContractRepository;
import com.example.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ContractService implements IContractService {
    @Autowired
    ContractRepository contractRepository;

    @Autowired
    AttachRepository attachRepository;

    @Autowired
    ContractDetailRepository contractDetailRepository;

    @Override
    public Page<Contract> findAll(Pageable pageable) {
        return contractRepository.getList(pageable);
    }

    @Override
    public List<AttachFacility> getAttachFacilities() {
        return attachRepository.findAll();
    }

    @Override
    public List<ContractDetail> getListContractDetail() {
        return contractDetailRepository.findAll();
    }

    @Override
    public List<ContractDetail> getContractDetail(int id) {
        return contractDetailRepository.findList(id);
    }

    @Override
    public Contract findById(int contractId) {
        return contractRepository.findById(contractId).orElse(null);
    }

    @Override
    public AttachFacility findAttachFacilityId(int attachId) {
        return attachRepository.findById(attachId).orElse(null);
    }

    @Override
    public void saveContractDetail(ContractDetail contractDetail) {
        contractDetailRepository.save(contractDetail);
    }

    @Override
    public void save(Contract contract) {
        contractRepository.save(contract);
    }
}
