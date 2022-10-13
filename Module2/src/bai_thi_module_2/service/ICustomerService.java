package bai_thi_module_2.service;

import java.io.IOException;
import java.text.ParseException;

public interface ICustomerService {

    void deleteCustomer() throws IOException, ParseException;

    void displayCustomer() throws IOException, ParseException;
}
