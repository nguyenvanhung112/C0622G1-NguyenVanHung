package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
public class HomeController {

    @GetMapping
    public String home(){
        return "/home";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "/login";
    }
    @GetMapping("/error")
    public String error() {
        return "/error.404";
    }
}
