package com.example.controller;

import com.example.dto.CustomerDTO;
import com.example.model.Customer;
import com.example.service.ICustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("customers")
public class CustomerController {
    @Autowired
    ICustomerService customerService;

    @GetMapping
    public ModelAndView showCustomerList(@RequestParam(value = "nameSearch", defaultValue = "") String nameSearch,
                                         @RequestParam(value = "email", defaultValue = "") String email,
                                         @RequestParam(value = "customerType", defaultValue = "") String customerType,
                                         @PageableDefault(value = 3) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("customer/list");
        modelAndView.addObject("customers", customerService.search(nameSearch, email, customerType, pageable));
        modelAndView.addObject("customerTypes", customerService.findAllCustomerType());
        modelAndView.addObject("customerType", customerType);
        modelAndView.addObject("email", email);
        modelAndView.addObject("nameSearch", nameSearch);
        return modelAndView;

    }

    @GetMapping("/create")
    public ModelAndView showForm(){
        ModelAndView modelAndView = new ModelAndView("customer/create");
        modelAndView.addObject("customerTypes", customerService.findAllCustomerType());
        modelAndView.addObject("customerDTO", new CustomerDTO());
        return modelAndView;
    }

    @PostMapping("/create")
    private ModelAndView create(@Validated @ModelAttribute CustomerDTO customerDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            ModelAndView modelAndView = new ModelAndView("customer/create");
            modelAndView.addObject("customerTypes", customerService.findAllCustomerType());
            modelAndView.addObject("customerDTO", customerDTO);
            modelAndView.addObject("message", "Add new not success!");
            return modelAndView;
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDTO, customer);
        customerService.save(customer);
        ModelAndView modelAndView = new ModelAndView("customer/create");
        modelAndView.addObject("customerTypes", customerService.findAllCustomerType());
        modelAndView.addObject("customerDTO", customerDTO);
        modelAndView.addObject("message", "Add new Successful!");
        return modelAndView;
    }
}
