package introduction_java.thuc_hanh;

import java.util.Scanner;

public class ToanTu {
    public static void main(String[] args) {
        float wight;
        float height;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter wight: ");
        wight = scanner.nextFloat();
        System.out.println("Enter height: ");
        height = scanner.nextFloat();
        float area = wight*height;
        System.out.println("Area: " + area);
    }

}
