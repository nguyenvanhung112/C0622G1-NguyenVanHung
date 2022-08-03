package ss2_array_loop.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class MinInArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập độ dài của mảng\n");
        int size = Integer.parseInt(sc.nextLine());
        int[] array = new int[size];
        int i;
        for (i = 0; i < size; i++) {
            System.out.print("Nhập vào các phần tử vị trí " + (i + 1) + "\n");
            array[i] = Integer.parseInt(sc.nextLine());
        }
        System.out.print("Mảng là " + Arrays.toString(array) + "\n");
        int min = array[0];
        int index = 0;
        for (i = 0; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
                index = i;
            }
        }
        System.out.print("Số bé nhất trong mảng là " + min + " tại vị trí " + index);
    }
}

