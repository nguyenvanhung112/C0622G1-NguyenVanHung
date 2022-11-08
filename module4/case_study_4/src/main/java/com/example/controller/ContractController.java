package com.example.controller;

import com.example.dto.ContractDTO;
import com.example.dto.FacilityDTO;
import com.example.model.*;
import com.example.model.Employee.Employee;
import com.example.service.IContractService;
import com.example.service.ICustomerService;
import com.example.service.IEmployeeService;
import com.example.service.IFacilityService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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

    @Autowired
    IFacilityService facilityService;
    @Autowired
    IEmployeeService employeeService;

    @Autowired
    ICustomerService customerService;

    @ModelAttribute("attachFacilityList")
    public List<AttachFacility> getListAttachFacility() {
        return contractService.getAttachFacilities();
    }

    @ModelAttribute("contractDetailList")
    public List<ContractDetail> getListContractDetail() {
        return contractService.getListContractDetail();
    }

    @ModelAttribute("facilityList")
    public List<Facility> getListFacility() {
        return facilityService.findAll();
    }
    @ModelAttribute("employeeList")
    public List<Employee> getListEmployee() {
        return employeeService.getListEmployee();
    }
    @ModelAttribute("customerList")
    public List<Customer> getListCustomer() {
        return customerService.findAll();
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

        Contract contract = contractService.findById(contractId);
        AttachFacility attachFacility = contractService.findAttachFacilityId(attachId);
        ContractDetail contractDetailExit = contractService.findContractDetailId(attachId,contractId);
        if (contractDetailExit != null) {
            contractDetailExit.setQuantity(contractDetailExit.getQuantity() + quantity);
            contractService.saveContractDetail(contractDetailExit);
        }else {
            ContractDetail contractDetail = new ContractDetail();
            contractDetail.setContractId(contract);
            contractDetail.setQuantity(quantity);
            contractDetail.setAttachFacilityId(attachFacility);
            contractService.saveContractDetail(contractDetail);
        }
        redirectAttributes.addFlashAttribute("message", "Add Attach Facility successfully!");
        return "redirect:/contract";
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("contract/create");
        modelAndView.addObject("contractDTO",new ContractDTO());
        return modelAndView;
    }
    @PostMapping("/create")
    public ModelAndView create(@ModelAttribute @Validated ContractDTO contractDTO, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            ModelAndView modelAndView = new ModelAndView("contract/create");
            modelAndView.addObject("contractDTO", contractDTO);
            modelAndView.addObject("message", "Add new not success!");
            return modelAndView;
        }
        Contract contract = new Contract();
        BeanUtils.copyProperties(contractDTO, contract);
        contractService.save(contract);
        ModelAndView modelAndView = new ModelAndView("contract/create");
        modelAndView.addObject("contractDTO", contractDTO);
        modelAndView.addObject("message", "Add new Successful!");
        return modelAndView;
    }
}
