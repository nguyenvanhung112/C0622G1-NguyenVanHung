package introduction_java.bai_tap;

import java.util.Scanner;

public class ChuyenDoiTienTe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào số USD");
        int usd = scanner.nextInt();
        int vnd = usd * 23000;
        System.out.println("Số VND là: " + vnd);
    }
}
