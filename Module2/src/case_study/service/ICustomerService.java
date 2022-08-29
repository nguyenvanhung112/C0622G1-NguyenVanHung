package case_study.service;

import java.io.IOException;

public interface ICustomerService {
    void displayListCustomers() throws IOException;

    void addNewCustomer() throws IOException;

    void editCustomer() throws IOException;


}
