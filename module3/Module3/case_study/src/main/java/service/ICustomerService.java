package service;

import model.person.Customer;

import java.util.List;
import java.util.Map;

public interface ICustomerService {
    List<Customer> getListCustomer();

    boolean deleteCustomer(int id);

    Map<String, String> addCustomer(Customer customer);

    List<Customer> findByCustomerByName(String name);

    Customer selectCustomer(int id);

    boolean updateCustomer(Customer customer);

}
