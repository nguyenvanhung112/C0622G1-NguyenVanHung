package repository;

import model.person.Customer;

import java.util.List;
import java.util.Map;

public interface IRepoCustomer {
   List<Customer> getListCustomer();

    boolean deleteCustomer(int id);

    boolean addCustomer(Customer customer);

    List<Customer> findCustomerByName(String name);

    Customer selectCustomer(int id);

    boolean updateCustomer(Customer customer);
}
