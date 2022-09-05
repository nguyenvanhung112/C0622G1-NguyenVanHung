package case_study.controller;

import case_study.service.IFacilityService;
import case_study.service.impl.Facility.FacilityService;

import java.io.IOException;
import java.util.Scanner;

public class FacilityController {
    IFacilityService facilityService = new FacilityService();
    static Scanner scanner = new Scanner(System.in);

    public void facilityMenu() throws IOException {
        while (true) {
            System.out.println("" +
                    "1\tDisplay list facility\n" +
                    "2\tAdd new facility\n" +
                    "3\tDisplay list facility maintenance\n" +
                    "4\tFacility maintenance\n" +
                    "5\tReturn main menu\n" +
                    "\tEnter function\n");
            int choice3 = Integer.parseInt(inputValidChoice());
            switch (choice3) {
                case 1:
                    facilityService.displayListFacilitys();
                    break;
                case 2:
                    facilityService.addNewFacility();
                    break;
                case 3:
                    facilityService.displayListFacilitysMaintenance();
                    break;
                case 4:
                    facilityService.facilityMaintenance();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Enter the correct function");
            }
        }
    }

    private static String inputValidChoice() {
        while (true) {
            String choiceString = scanner.nextLine();
            if (choiceString.matches("[1-5]")) {
                return choiceString;
            } else {
                System.out.print("You entered invalid! Again: ");
            }
        }
    }
}