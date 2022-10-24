package com.example.form_register.service;

import com.example.form_register.model.User;
import com.example.form_register.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    IUserRepository userRepository;
    @Override
    public void save(User user) {
        userRepository.save(user);
    }
}
