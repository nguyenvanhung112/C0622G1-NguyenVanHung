package com.example.controller;

import com.example.dto.CustomerDTO;
import com.example.model.Customer;
import com.example.model.CustomerType;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("customers")
public class CustomerController {
    @Autowired
    ICustomerService customerService;

    @ModelAttribute("customerTypes")
    public List<CustomerType> getListCustomerTypes() {
        return customerService.findAllCustomerType();
    }

    @GetMapping
    public ModelAndView showCustomerList(@RequestParam(value = "nameSearch", defaultValue = "") String nameSearch,
                                         @RequestParam(value = "email", defaultValue = "") String email,
                                         @RequestParam(value = "customerType", defaultValue = "") String customerType,
                                         @PageableDefault(value = 3) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("customer/list");
        modelAndView.addObject("customers", customerService.search(nameSearch, email, customerType, pageable));
        modelAndView.addObject("customerType", customerType);
        modelAndView.addObject("email", email);
        modelAndView.addObject("nameSearch", nameSearch);
        return modelAndView;

    }

    @GetMapping("/create")
    public ModelAndView showForm() {
        ModelAndView modelAndView = new ModelAndView("customer/create");
        modelAndView.addObject("customerDTO", new CustomerDTO());
        return modelAndView;
    }

    @PostMapping("/create")
    private ModelAndView create(@Validated @ModelAttribute CustomerDTO customerDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("customer/create");
            modelAndView.addObject("customerDTO", customerDTO);
            modelAndView.addObject("message", "Add new not success!");
            return modelAndView;
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDTO, customer);
        customerService.save(customer);
        ModelAndView modelAndView = new ModelAndView("customer/create1");
        modelAndView.addObject("customerDTO", customerDTO);
        modelAndView.addObject("message", "Add new Successful!");
        return modelAndView;
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam int id, RedirectAttributes redirectAttributes) {
        customerService.delete(id);
        redirectAttributes.addFlashAttribute("message", "Delete customer successfully!");
        return "redirect:/customers";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showFormEdit(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("customer/edit");
        Optional<Customer> customer = customerService.findCustomerByID(id);
        CustomerDTO customerDTO = new CustomerDTO();
        BeanUtils.copyProperties(customer.get(), customerDTO);
        modelAndView.addObject("customerDTO", customerDTO);
        return modelAndView;
    }

    @PostMapping("/edit")
    public ModelAndView edit(@ModelAttribute @Validated CustomerDTO customerDTO, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("customer/edit");
            modelAndView.addObject("customerDTO", customerDTO);
            return modelAndView;
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDTO, customer);
        customerService.save(customer);
        ModelAndView modelAndView = new ModelAndView("customer/edit");
        modelAndView.addObject("customerDTO", customerDTO);
        modelAndView.addObject("message", "Customer edited successfully");
        return modelAndView;
    }
}
