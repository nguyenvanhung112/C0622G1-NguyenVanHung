package case_study.controller;

import case_study.service.*;
import case_study.service.impl.*;

import java.util.Scanner;

public class FuramaController {
    static Scanner scanner = new Scanner(System.in);
    IFacilityService facilityService = new FacilityService();

    IContactService contactService = new ContactService();
    IBookingService bookingService = new BookingService();
    IPromotionService promotionService = new PromotionService();
    EmployeeController employeeController = new EmployeeController();
    CustomerController customerController = new CustomerController();
    public void displayMainMenu() {
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
                    System.out.println("" +
                            "1\tDisplay list facility\n" +
                            "2\tAdd new facility\n" +
                            "3\tDisplay list facility maintenance\n" +
                            "4\tReturn main menu\n" +
                            "\tEnter function\n");
                    int choice3 = Integer.parseInt(scanner.nextLine());
                    switch (choice3) {
                        case 1:
                            facilityService.displayListFacilitys();
                            break;
                        case 2:
                            facilityService.addNewFacility();
                            break;
                        case 3:
                            facilityService.editFacility();
                            break;
                        case 4:
                            break;
                        default:
                            System.out.println("Enter the correct function");
                    }
                    break;
                case 4:
                    System.out.println("" +
                            "1.\tAdd new booking\n" +
                            "2.\tDisplay list booking\n" +
                            "3.\tCreate new constracts\n" +
                            "4.\tDisplay list contracts\n" +
                            "5.\tEdit contracts\n" +
                            "6.\tReturn main menu\n" +
                            "\tEnter function\n");
                    int choice4 = Integer.parseInt(scanner.nextLine());
                    switch (choice4) {
                        case 1:
                            bookingService.addNewBooking();
                            break;
                        case 2:
                            bookingService.dislayListBooking();
                            break;
                        case 3:
                            contactService.creatNewContracts();
                            break;
                        case 4:
                            contactService.displayListContracts();
                            break;
                        case 5:
                            contactService.editContracts();
                        case 6:
                            break;
                        default:
                            System.out.println("Enter the correct function");
                    }
                    break;
                case 5:
                    System.out.println("" +
                            "1.\tDisplay list customers use service\n" +
                            "2.\tDisplay list customers get voucher\n" +
                            "3.\tReturn main menu\n");
                    int choice5 = Integer.parseInt(scanner.nextLine());
                    switch (choice5) {
                        case 1:
                            promotionService.displayListCustomersUseService();
                            break;
                        case 2:
                            promotionService.dislayListCustomersGetVoucher();
                            break;
                        case 3:
                            break;
                        default:
                            System.out.println("Enter the correct function");
                    }
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Enter the correct function");
            }
        }
    }
}
