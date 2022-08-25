package case_study.service.impl;

import case_study.model.person.Customer;
import case_study.service.ICustomerService;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CustomerService implements ICustomerService {
    static Scanner scanner = new Scanner(System.in);
    static List<Customer> customers = new LinkedList<>();
    @Override
    public void displayListCustomers() {
        for (Customer item: customers) {
            System.out.println(item);
        }
    }

    @Override
    public void addNewCustomer() {
        Customer customer = this.infoCustomer();
        customers.add(customer);
    }

    private Customer infoCustomer() {
        System.out.println("Input name");
        String name = scanner.nextLine();
        System.out.println("Input date of birth");
        String dateOfBirth = scanner.nextLine();
        System.out.println("Input gender");
        String gender = scanner.nextLine();
        System.out.println("Input ID card");
        int idCard = Integer.parseInt(scanner.nextLine());
        System.out.println("Input phone");
        int phone = Integer.parseInt(scanner.nextLine());
        System.out.println("Input Email");
        String email = scanner.nextLine();
        System.out.println("Input Customer Code");
        String customerCode= scanner.nextLine();
        System.out.println("Input Type Customer");
        String typeCustomer = scanner.nextLine();
        System.out.println("Input Address");
        String address = scanner.nextLine();
        return new Customer(name,dateOfBirth,gender,idCard,phone,email,customerCode,typeCustomer,address);
    }

    @Override
    public void editCustomer() {

    }
}
