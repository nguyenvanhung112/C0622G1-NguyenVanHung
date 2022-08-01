package introduction_java.thuc_hanh;

import java.util.Scanner;

public class ChiSoCanNang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double weight , height ,bmi;
        System.out.println("Nhập cân nặng");
        weight = scanner.nextDouble();
        System.out.println("Nhập chiều cao");
        height = scanner.nextDouble();
        bmi = weight/(height*height);
        System.out.println("Chỉ số cân nặng cơ thể là " + bmi);
        if (bmi > 18){
            System.out.println("Quá gầy");
        }else if (bmi<25.0){
            System.out.println("Bình thường");
        }else if (bmi < 30){
            System.out.println("Mập");
        }else {
            System.out.println("Quá mập");
        }
    }
}
