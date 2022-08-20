package ss13_debug_exception.bai_tap;

import java.util.Scanner;

public class IllegalTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a;
        double b;
        double c;
        while (true) {
            try {
                System.out.println("Nhập cạnh a");
                a = Double.parseDouble(scanner.nextLine());
                System.out.println("Nhập cạnh b");
                b = Double.parseDouble(scanner.nextLine());
                System.out.println("Nhập cạnh c");
                c = Double.parseDouble(scanner.nextLine());
                System.out.println(checkTriangle(a, b, c));
                break;
            } catch (NumberFormatException e) {
                System.out.println("Nhập vào 1 số");
            } catch (IllegalTriangleException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static String checkTriangle(double a, double b, double c) throws IllegalTriangleException {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalTriangleException("Nhập cạnh lớn hơn 0");
        } else if (a + b < c || a + c < b || b + c < a) {
            throw new IllegalTriangleException("Không phải là tam giác");
        }
        return "Hình chữ nhật có cạnh a , b , c lần lượt là " + a + " " + b + " " + c;
    }
}
