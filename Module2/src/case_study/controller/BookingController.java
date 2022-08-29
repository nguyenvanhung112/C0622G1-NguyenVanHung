package case_study.controller;

import case_study.service.IBookingService;
import case_study.service.IContactService;
import case_study.service.impl.BookingService;
import case_study.service.impl.ContactService;

import java.io.IOException;
import java.util.Scanner;

public class BookingController {
    IBookingService bookingService = new BookingService();
    IContactService contactService = new ContactService();
    static Scanner scanner = new Scanner(System.in);

    public void bookingMenu() throws IOException {
        while (true) {
            System.out.println("" +
                    "1.\tAdd new booking\n" +
                    "2.\tDisplay list booking\n" +
                    "3.\tCreate new constracts\n" +
                    "4.\tDisplay list contracts\n" +
                    "5.\tEdit contracts\n" +
                    "6.\tReturn main menu\n" +
                    "\tEnter function\n");
            int choice4 = Integer.parseInt(inputValidChoice());
            switch (choice4) {
                case 1:
                    bookingService.addNewBooking();
                    break;
                case 2:
                    bookingService.displayListBooking();
                    break;
                case 3:
                    contactService.creatNewContracts();
                    break;
                case 4:
                    contactService.displayListContracts();
                    break;
                case 5:
                    contactService.editContracts();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Enter the correct function");
            }
        }
    }

    public static String inputValidChoice() {
        while (true) {
            String choiceString = scanner.nextLine();
            if (choiceString.matches("[1-6]")) {
                return choiceString;
            } else {
                System.out.print("You entered invalid! Again: ");
            }
        }
    }
}
