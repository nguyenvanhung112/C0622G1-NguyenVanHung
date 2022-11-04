package com.example.controller;

import com.example.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("employees")
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @GetMapping
    private ModelAndView getListEmployees(@PageableDefault(value = 3) Pageable pageable){
        ModelAndView modelAndView = new ModelAndView("employee/list");
        modelAndView.addObject("employees", employeeService.findAll(pageable));
        return modelAndView;
    }

}
