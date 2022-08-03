package ss2_array_loop.bai_tap;

import java.util.Scanner;

public class CountOfCharacterInString {
    public static void main(String[] args) {
        String str = "abcabaaccbaa";
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập vào giá trị\n");
        char character = sc.nextLine().charAt(0);
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == character) {
                count++;
            }
        }
        System.out.print("Tổng số lần xuất hiện của " + character + " là " + count);
    }
}
