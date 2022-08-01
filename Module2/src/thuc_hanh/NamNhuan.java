package thuc_hanh;

import java.util.Scanner;

public class NamNhuan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year;
        System.out.println("Nhập số năm");
        year = scanner.nextInt();
        if (year % 4 == 0 && !(year % 100 == 0 && year % 400 != 0)) {
            System.out.println("Đây là năm nhuận");
        } else {
            System.out.println("Đây k phải là năm nhuận");
        }
    }
}
