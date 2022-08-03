package ss2_array_loop.thuc_hanh;

import java.util.Arrays;
import java.util.Scanner;

public class StudentsPassing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size;
        int[] array;
        do {
            System.out.print("Nhập vào số lượng sinh viên\n");
            size = sc.nextInt();
            if (size > 30) {
                System.out.print("Số lượng sinh viên không quá 30\n");
            }
        } while (size > 30);
        array = new int[size];
        int i;
        for (i = 0; i < size; i++) {
            System.out.print("Nhập vào số điểm của sinh viên " + (i + 1) + "\n");
            array[i] = sc.nextInt();
        }
        int count = 0;
        System.out.print("Danh sách điểm của sinh viên " + Arrays.toString(array) +"\n");
        for (i = 0; i < array.length; i++) {
            if (array[i] >= 5 && array[i] <=10){
                count++;
            }
        }
        System.out.print("Số lượng sinh viên qua môn là " + count);
    }
}
