package case_study.controller;

import case_study.service.ICustomerService;
import case_study.service.impl.CustomerService;

import java.io.IOException;
import java.util.Scanner;

public class CustomerController {
    ICustomerService customerService = new CustomerService();
    static Scanner scanner = new Scanner(System.in);

    public void customerMenu() throws IOException {
        while (true) {
            System.out.println("" +
                    "1.\tDisplay list customers\n" +
                    "2.\tAdd new customer\n" +
                    "3.\tEdit customer\n" +
                    "4.\tReturn main menu\n" +
                    "\tEnter function\n");
            int choice = Integer.parseInt(inputValidChoice());
            boolean check = true;
            switch (choice) {
                case 1:
                    customerService.displayListCustomers();
                    check = true;
                    break;
                case 2:
                    customerService.addNewCustomer();
                    check = true;
                    break;
                case 3:
                    customerService.editCustomer();
                    check = true;
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Enter the correct function");
            }
            if (!check) break;
        }
    }

    private static String inputValidChoice() {
        while (true) {
            String choiceString = scanner.nextLine();
            if (choiceString.matches("[1-4]")) {
                return choiceString;
            } else {
                System.out.print("You entered invalid! Again: ");
            }
        }
    }
}
