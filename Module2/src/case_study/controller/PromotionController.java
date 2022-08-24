package case_study.controller;

import case_study.service.IPromotionService;
import case_study.service.impl.PromotionService;

import java.util.Scanner;

public class PromotionController {
    IPromotionService promotionService = new PromotionService();
    Scanner scanner = new Scanner(System.in);

    public void promotionMenu() {
        while (true) {
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
        }
    }
}
