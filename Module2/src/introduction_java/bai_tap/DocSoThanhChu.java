package introduction_java.bai_tap;

import java.util.Scanner;

public class DocSoThanhChu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào 1 số ");
        int number = scanner.nextInt();
        switch (number) {
            case 1:
                System.out.println("one");
                break;
            case 2:
                System.out.println("two");
                break;
            case 3:
                System.out.println("three");
                break;
            case 4:
                System.out.println("four");
                break;
            case 5:
                System.out.println("five");
                break;
            case 6:
                System.out.println("six");
                break;
            case 7:
                System.out.println("seven");
                break;
            case 8:
                System.out.println("eight");
                break;
            case 9:
                System.out.println("nice");
                break;
            case 10:
                System.out.println("ten");
                break;
            case 11:
                System.out.println("eleven");
                break;
            case 12:
                System.out.println("twelve");
                break;
            case 13:
                System.out.println(number + "teen");
            default:
                System.out.println("Không biết");
                break;
        }
    }
}
