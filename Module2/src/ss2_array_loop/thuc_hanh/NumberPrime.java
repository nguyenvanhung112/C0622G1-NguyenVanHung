package ss2_array_loop.thuc_hanh;

import java.util.Scanner;

public class NumberPrime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Nhập vào 1 số ");
        int number = sc.nextInt();
        if (number < 2) {
            System.out.printf(number + " Không phải số nguyên tố");
        } else {
            int i = 2;
            boolean is_prime = true;
            while (i < number) {
                if (number % i == 0) {
                    is_prime = false;
                    break;
                }
                i++;
            }
            if (is_prime) {
                System.out.printf(number + " Đây là số nguyên tố");
            } else {
                System.out.printf(number + " Không phải là  số nguyên tố");
            }
        }
    }
}
