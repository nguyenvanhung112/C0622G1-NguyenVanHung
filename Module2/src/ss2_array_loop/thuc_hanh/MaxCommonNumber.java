package ss2_array_loop.thuc_hanh;

import java.util.Scanner;

public class MaxCommonNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào số a");
        int a = sc.nextInt();
        System.out.println("Nhập vào số b");
        int b = sc.nextInt();
        a = Math.abs(a); //Trả về phần dương
        b = Math.abs(b);
        if (a == 0 || b == 0) {
            System.out.println("không có ước chung");
        }
        while (a != b) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }System.out.println("Ước chung là " + a);
    }
}
