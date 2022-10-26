package com.example.form_register.controller;

import com.example.form_register.dto.UserDTO;
import com.example.form_register.model.User;
import com.example.form_register.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    IUserService userService;
    @GetMapping("")
    public ModelAndView register() {
        ModelAndView modelAndView = new ModelAndView("user/index");
        modelAndView.addObject("userDTO", new UserDTO());
        return modelAndView;
    }

    @PostMapping("/register")
    public ModelAndView accept(@Validated @ModelAttribute UserDTO userDTO, BindingResult bindingResult) {
        new UserDTO().validate(userDTO, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("user/index");
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("user/result");
            User user = new User();
            BeanUtils.copyProperties(userDTO,user);
            userService.save(user);
            return modelAndView;
        }
    }
}
