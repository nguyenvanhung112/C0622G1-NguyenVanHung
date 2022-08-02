package ss2_array_loop.thuc_hanh;

import java.util.Scanner;

public class InterestCalulator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Nhập vào số tiền gửi");
        double money = sc.nextDouble();
        System.out.printf("Nhập vào số tháng gửi");
        int month = sc.nextInt();
        System.out.printf("Nhập vào lãi suất");
        double interest = sc.nextFloat();
        double totalInterest = 0;
        for (int i = 0; i < month; i++) {
            totalInterest += (money*interest/100);
        }System.out.printf("Tiền lãi là " + totalInterest);
    }
}
