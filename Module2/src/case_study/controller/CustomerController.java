package case_study.controller;

import case_study.service.ICustomerService;
import case_study.service.impl.CustomerService;

import java.util.Scanner;

public class CustomerController {
    ICustomerService customerService = new CustomerService();
    Scanner scanner = new Scanner(System.in);
    public void customerMenu(){
        System.out.println("" +
                "1.\tDisplay list customers\n" +
                "2.\tAdd new customer\n" +
                "3.\tEdit customer\n" +
                "4.\tReturn main menu\n" +
                "\tEnter function\n");
        int choice2 = Integer.parseInt(scanner.nextLine());
        switch (choice2) {
            case 1:
                customerService.displayListCustomers();
                break;
            case 2:
                customerService.addNewCustomer();
                break;
            case 3:
                customerService.editCustomer();
                break;
            case 4:
                return;
            default:
                System.out.println("Enter the correct function");
        }
    }
}
