package case_study.controller;

import case_study.service.*;
import case_study.service.impl.*;

import java.io.IOException;
import java.util.Scanner;

public class FuramaController {
    static Scanner scanner = new Scanner(System.in);
    EmployeeController employeeController = new EmployeeController();
    CustomerController customerController = new CustomerController();
    PromotionController promotionController = new PromotionController();
    BookingController bookingController = new BookingController();
    FacilityController facilityController = new FacilityController();
    public void displayMainMenu() throws IOException {
        while (true) {
            System.out.println("_____________________________________________________");
            System.out.println("FURAMA RESORT");
            System.out.println("" +
                    "1.\tEmployee Management\n" +
                    "2.\tCustomer Management\n" +
                    "3.\tFacility Management \n" +
                    "4.\tBooking Management\n" +
                    "5.\tPromotion Management\n" +
                    "6.\tExit\n" +
                    "\tEnter function\n");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    employeeController.employeeMenu();
                    break;
                case 2:
                    customerController.customerMenu();
                    break;
                case 3:
                    facilityController.facilityMenu();
                    break;
                case 4:
                   bookingController.bookingMenu();
                    break;
                case 5:
                    promotionController.promotionMenu();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Enter the correct function");
            }
        }
    }
}
