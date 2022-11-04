package com.example.excercise2.repository;

import com.example.excercise2.model.AppUser;
import com.example.excercise2.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<AppUser,Long> {
    AppUser findByUserName(String userName);
}
