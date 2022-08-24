package case_study.controller;

import case_study.service.IBookingService;
import case_study.service.IContactService;
import case_study.service.impl.BookingService;
import case_study.service.impl.ContactService;

import java.util.Scanner;

public class BookingController {
    IBookingService bookingService = new BookingService();
    IContactService contactService = new ContactService();
    Scanner scanner = new Scanner(System.in);

    public void bookingMenu() {
        while (true) {
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
        }
    }
}
