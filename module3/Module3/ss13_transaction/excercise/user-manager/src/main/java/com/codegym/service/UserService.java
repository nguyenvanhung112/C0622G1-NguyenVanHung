package com.codegym.service;

import com.codegym.dao.UserDAO;
import com.codegym.model.User;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Comparator;
import java.util.List;

public class UserService implements IUserService {
    UserDAO userDAO = new UserDAO();
    @Override
    public void insertUser(User user) throws SQLException {
        userDAO.insertUser(user);
    }

    @Override
    public User selectUser(int id) {
        return userDAO.selectUser(id);
    }

    @Override
    public List<User> selectAllUsers() {
        return userDAO.selectAllUsers();
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        return userDAO.deleteUser(id);
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        return userDAO.updateUser(user);
    }

    @Override
    public List<User> findByCountry(String country) {
        return userDAO.findByCountry(country);
    }

    @Override
    public List<User> selectUserByCallableStatement() {
        return userDAO.selectUserByCallableStatement();
    }

    @Override
    public boolean updateUserByCallableStatement(User user) {
        return userDAO.updateUserByCallableStatement(user);
    }

    @Override
    public boolean deleteUserByCallableStatement(int id) {
        return userDAO.deleteUserByCallableStatement(id);
    }
    public List<User> sortByName() throws IOException {
        return userDAO.sortByName();
    }
}
