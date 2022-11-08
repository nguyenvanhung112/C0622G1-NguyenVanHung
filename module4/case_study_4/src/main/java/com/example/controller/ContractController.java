package com.example.controller;

import com.example.dto.ContractDTO;
import com.example.model.AttachFacility;
import com.example.model.Contract;
import com.example.model.ContractDetail;
import com.example.service.IContractService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.function.Function;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    IContractService contractService;

    @ModelAttribute("attachFacilityList")
    public List<AttachFacility> getListAttachFacility() {
        return contractService.getAttachFacilities();
    }

    @ModelAttribute("contractDetailList")
    public List<ContractDetail> getListContractDetail() {
        return contractService.getListContractDetail();
    }


    @GetMapping
    public String list(Model model,
                       @PageableDefault(value = 3) Pageable pageable) {
        Page<Contract> contractPage = contractService.findAll(pageable);

        Page<ContractDTO> contractDTOPage = contractPage.map(new Function<Contract, ContractDTO>() {
            @Override
            public ContractDTO apply(Contract contract) {
                ContractDTO contractDTO = new ContractDTO();
                BeanUtils.copyProperties(contract, contractDTO);
                contractDTO.getTotalCost();
                return contractDTO;
            }

        });

        model.addAttribute("contractList", contractDTOPage);
        return "contract/list";

    }

    @PostMapping("/create-attach")
    public String createAttach(@RequestParam(value = "attachId") int attachId,
                                     @RequestParam(value = "quantity") int quantity,
                                     @RequestParam(value = "contractId") int contractId, RedirectAttributes redirectAttributes){

        ContractDetail contractDetail = new ContractDetail();
        Contract contract = contractService.findById(contractId);
        contractDetail.setContractId(contract);
        contractDetail.setQuantity(quantity);
        contractDetail.setAttachFacilityId(contractService.findAttachFacilityId(attachId));
        contractService.saveContractDetail(contractDetail);
        redirectAttributes.addFlashAttribute("message", "Add AttachFacility successfully!");
        return "redirect:/contract";
    }
}
