package case_study.service;


import java.io.IOException;

public interface IEmployeeService {


    void displayListEmployees() throws IOException;

    void addNewEmployee() throws IOException;

    void editEmployee() throws IOException;

}
