package case_study.controller;

import case_study.service.IPromotionService;
import case_study.service.impl.PromotionService;

import java.util.Scanner;

public class PromotionController {
    IPromotionService promotionService = new PromotionService();
    static Scanner scanner = new Scanner(System.in);

    public void promotionMenu() {
        while (true) {
            System.out.println("" +
                    "1.\tDisplay list customers use service\n" +
                    "2.\tDisplay list customers get voucher\n" +
                    "3.\tReturn main menu\n");
            int choice5 = Integer.parseInt(inputValidChoice());
            boolean check = true;
            switch (choice5) {
                case 1:
                    promotionService.displayListCustomersUseService();
                    check = true;
                    break;
                case 2:
                    promotionService.dislayListCustomersGetVoucher();
                    check = true;
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Enter the correct function");
            }
            if (!check) break;
        }
    }

    public static String inputValidChoice() {
        while (true) {
            String choiceString = scanner.nextLine();
            if (choiceString.matches("[1-3]")) {
                return choiceString;
            } else {
                System.out.print("You entered invalid! Again: ");
            }
        }
    }
}
