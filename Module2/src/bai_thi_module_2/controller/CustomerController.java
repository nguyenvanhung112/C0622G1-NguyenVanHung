package bai_thi_module_2.controller;

import bai_thi_module_2.model.Employee;
import bai_thi_module_2.service.impl.CustomerService;
import bai_thi_module_2.service.impl.EmployeeService;
import bai_thi_module_2.service.impl.StudentService;
import case_study.controller.BookingController;
import case_study.controller.EmployeeController;
import case_study.controller.FacilityController;
import case_study.controller.PromotionController;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class CustomerController {
    static Scanner scanner = new Scanner(System.in);
    CustomerService customerService = new CustomerService();
    public void displayMainMenu() throws IOException, ParseException {
        while (true) {
            System.out.println("_____________________________________________________");
            System.out.println("CODE GYM");
            System.out.println("" +
                    "1.\tThêm mới nhân sự\n" +
                    "2.\tXóa nhân sự\n" +
                    "3.\tXem danh sách nhân sự\n" +
                    "4.\tThoát\n" +
                    "\tEnter function\n");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    customerService.addCustomemrMenu();
                    break;
                case 2:
                    customerService.deleteCustomer();
                    break;
                case 3:
                    customerService.displayCustomer();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Enter the correct function");
            }
        }
    }

}
