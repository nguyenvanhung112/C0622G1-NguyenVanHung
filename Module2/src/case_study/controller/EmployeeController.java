package case_study.controller;

import case_study.service.IEmployeeService;
import case_study.service.impl.EmployeeService;

import java.io.IOException;
import java.util.Scanner;

public class EmployeeController {
    static Scanner scanner = new Scanner(System.in);
    IEmployeeService employeeService = new EmployeeService();

    public void employeeMenu() throws IOException {
        while (true) {
            System.out.println("" +
                    "1\tDisplay list employees\n" +
                    "2\tAdd new employee\n" +
                    "3\tEdit employee\n" +
                    "4\tReturn main menu\n" +
                    "\tEnter function\n");
            int choice1 = Integer.parseInt(inputValidChoice());
            switch (choice1) {
                case 1:
                    employeeService.displayListEmployees();
                    break;
                case 2:
                    employeeService.addNewEmployee();
                    break;
                case 3:
                    employeeService.editEmployee();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Enter the correct function");
            }
        }
    }

    public static String inputValidChoice() {
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
