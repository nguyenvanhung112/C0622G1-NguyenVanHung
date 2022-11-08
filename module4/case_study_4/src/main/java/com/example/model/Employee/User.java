package com.example.model.Employee;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class User {

    @Id
    private String userName;


    @OneToOne(mappedBy = "user")
    @JsonBackReference
    private Employee employee;

    private String password;

    @ManyToMany
    @JsonBackReference
    @JsonIgnore
    @JoinTable(name = "user_role",
    joinColumns = @JoinColumn(name = "user_name"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles;

    public User() {
    }

    public User(String userName, Employee employee, String password, Set<Role> roles) {
        this.userName = userName;
        this.employee = employee;
        this.password = password;
        this.roles = roles;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
