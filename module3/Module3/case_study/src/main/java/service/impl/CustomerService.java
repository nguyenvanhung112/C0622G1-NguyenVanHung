package service.impl;

import model.person.Customer;
import repository.IRepoCustomer;
import repository.impl.RepoCustomer;
import service.ICustomerService;
import service.Validate.Validation;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerService implements ICustomerService {
    private IRepoCustomer repoCustomer = new RepoCustomer();

    @Override
    public List<Customer> getListCustomer() {
        return repoCustomer.getListCustomer();
    }

    @Override
    public boolean deleteCustomer(int id) {
        return repoCustomer.deleteCustomer(id);
    }

    @Override
    public Map<String, String> addCustomer(Customer customer) {
        Map<String, String> errorMap = new HashMap<>();
        if (customer.getEmail().equals("")) {
            errorMap.put("email", "Email không được để trống!");
        } else if (!Validation.checkEmail(customer.getEmail())) {
            errorMap.put("email", "Email không đúng định dạng");
        }
        if (customer.getName().equals("")) {
            errorMap.put("name", "Name không được để trống!");
        } else if (!Validation.checkName(customer.getName())) {
            errorMap.put("name", "Name không đúng định dạng");
        }
        if (customer.getAddress().equals("")) {
            errorMap.put("address", "Address không được để trống!");
        }
        if (customer.getIdCard().equals("")) {
            errorMap.put("idCard", "IdCard không được để trống!");
        }
        if (customer.getPhone().equals("")) {
            errorMap.put("phoneNumber", "Phone không được để trống!");
        } else if (!Validation.checkPhone(customer.getPhone())) {
            errorMap.put("phoneNumber", "Phone không đúng định dạng (XX)-(0XXXXXXXXX)");
        }
        if (customer.getCustomerId() == 100) {
            errorMap.put("customerTypeId", "Customer Type không được để trống!");
        }
        if (errorMap.size() == 0) {
            boolean check = repoCustomer.addCustomer(customer);
            if (!check){
                errorMap.put("check","Thêm data base không thành công");
            }
        }
        return errorMap;
    }

    @Override
    public List<Customer> findByCustomerByName(String name) {
        return repoCustomer.findCustomerByName(name);
    }

    @Override
    public Customer selectCustomer(int id) {
        return repoCustomer.selectCustomer(id);
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        return repoCustomer.updateCustomer(customer);
    }
}
