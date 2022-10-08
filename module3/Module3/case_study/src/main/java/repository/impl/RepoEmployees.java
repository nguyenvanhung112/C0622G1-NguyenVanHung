package repository.impl;

import model.person.Employee;
import repository.IRepoEmployees;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RepoEmployees implements IRepoEmployees {
    private static final String INSERT_EMPLOYEES_SQL = "INSERT INTO employee (name,date_of_birth,id_card,salary,phone_number, email,address,position_id,education_degree_id,division_id,username) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String SELECT_EMPLOYEES_BY_ID = "select * from employee where id =?";
    private static final String SELECT_ALL_EMPLOYEES = "select * from employee where is_delete = 0;";
    private static final String DELETE_EMPLOYEES_SQL = "update employee set is_delete = 1 where id = ?;";
    private static final String UPDATE_EMPLOYEES_SQL = "update employee set name = ?,date_of_birth=?,id_card =?,salary=?,phone_number=?, email= ?, address =?,position_id=?,education_degree_id=?,division_id =?, username =? where id = ?;";
    private static BaseRepository baseRepository = new BaseRepository();

    @Override
    public List<Employee> getListEmployees() {
        List<Employee> employeeList = new ArrayList<>();
        Connection connection = baseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareCall(SELECT_ALL_EMPLOYEES);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String date_of_birth = rs.getString("date_of_birth");
                String idCard = rs.getString("id_card");
                double salary = rs.getDouble("salary");
                String phoneNumber = rs.getString("phone_number");
                String email = rs.getString("email");
                String address = rs.getString("address");
                int positionId = rs.getInt("position_id");
                int educationDegreeId = rs.getInt("education_degree_id");
                int divisionId = rs.getInt("division_id");
                String username = rs.getString("username");
                employeeList.add(new Employee(id, name, date_of_birth, idCard, salary, phoneNumber, email, address, positionId, educationDegreeId, divisionId, username));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employeeList;
    }

    @Override
    public void addEmployee(Employee newEmployee) {
        Connection connection = baseRepository.getConnection();
        System.out.println(INSERT_EMPLOYEES_SQL);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMPLOYEES_SQL);
            preparedStatement.setString(1, newEmployee.getName());
            preparedStatement.setString(2, newEmployee.getDateOfBirth());
            preparedStatement.setString(3, newEmployee.getIdCard());
            preparedStatement.setDouble(4, newEmployee.getWage());
            preparedStatement.setString(5, newEmployee.getPhone());
            preparedStatement.setString(6, newEmployee.getEmail());
            preparedStatement.setString(7, newEmployee.getAddress());
            preparedStatement.setInt(8, newEmployee.getPositionId());
            preparedStatement.setInt(9, newEmployee.getEducationDegreeId());
            preparedStatement.setInt(10, newEmployee.getDivisionId());
            preparedStatement.setString(11, newEmployee.getUsername());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Employee selectEmployee(int id) {
        Employee employee = null;
        Connection connection = baseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMPLOYEES_BY_ID);
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String date_of_birth = rs.getString("date_of_birth");
                String idCard = rs.getString("id_card");
                double salary = rs.getDouble("salary");
                String phoneNumber = rs.getString("phone_number");
                String email = rs.getString("email");
                String address = rs.getString("address");
                int positionId = rs.getInt("position_id");
                int educationDegreeId = rs.getInt("education_degree_id");
                int divisionId = rs.getInt("division_id");
                String username = rs.getString("username");
                employee = new Employee(id, name, date_of_birth, idCard, salary, phoneNumber, email, address, positionId, educationDegreeId, divisionId, username);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employee;
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        boolean rowUpdated = false;

        try (Connection connection = baseRepository.getConnection();PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_EMPLOYEES_SQL))
        {
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getDateOfBirth());
            preparedStatement.setString(3, employee.getIdCard());
            preparedStatement.setDouble(4, employee.getWage());
            preparedStatement.setString(5, employee.getPhone());
            preparedStatement.setString(6, employee.getEmail());
            preparedStatement.setString(7, employee.getAddress());
            preparedStatement.setInt(8, employee.getPositionId());
            preparedStatement.setInt(9, employee.getEducationDegreeId());
            preparedStatement.setInt(10, employee.getDivisionId());
            preparedStatement.setString(11, employee.getUsername());
            preparedStatement.setInt(12, employee.getEmployeeId());
            System.out.println(preparedStatement);
            rowUpdated = preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowUpdated;
    }

    @Override
    public boolean deleteEmployee(int id) {
        boolean rowDelete = false;
        Connection connection = baseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_EMPLOYEES_SQL);
            preparedStatement.setInt(1,id);
            System.out.println(preparedStatement);
            rowDelete = preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowDelete;
    }

    @Override
    public List<Employee> selectEmployeeByName(String search) {
        List<Employee> list = new ArrayList<>();
        List<Employee> employeeListAll = getListEmployees();
        for (Employee item: employeeListAll) {
            if (item.getName().contains(search)){
                list.add(item);
            }
        }
        return list;
    }
}
