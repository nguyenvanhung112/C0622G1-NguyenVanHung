package case_study.controller;

import case_study.service.IFacilityService;
import case_study.service.impl.FacilityService;

import java.util.Scanner;

public class FacilityController {
    IFacilityService facilityService = new FacilityService();
    Scanner scanner = new Scanner(System.in);

    public void facilityMenu() {
        while (true) {
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
                   return;
                default:
                    System.out.println("Enter the correct function");
            }
            break;
        }
    }
}
