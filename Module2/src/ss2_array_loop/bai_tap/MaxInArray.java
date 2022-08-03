package ss2_array_loop.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class MaxInArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row;
        int columns;
        do {
            System.out.print("Nhập độ dài của mảng\n");
            row = Integer.parseInt(sc.nextLine());
            if (row < 0) {
                System.out.print("Nhập lại độ dài lớn hơn 0");
            }
        } while (row < 0);
        do {
            System.out.print("Nhập số phần tử có trong mảng\n");
            columns = Integer.parseInt(sc.nextLine());
            if (columns < 0) {
                System.out.print("Nhập lại độ dài lớn hơn 0");
            }
        } while (columns < 0);

        double[][] array = new double[row][columns];
        int i;
        int j;
        for (i = 0; i < row; i++) {
            for (j = 0; j < columns; j++) {
                System.out.print("Nhập vào phần tử " + i + j + "\n");
                array[i][j] = Integer.parseInt(sc.nextLine());
            }
        }
        System.out.print("Mảng 2 chiều là " + Arrays.deepToString(array) + "\n");
        double max = array[0][0];
        int index1 = 0;
        int index2 = 0;
        for (i = 0; i < array.length; i++) {
            for (j = 0; j <= i; j++) {
                if (max < array[i][j]) {
                    max = (int) array[i][j];
                    index1 = i;
                    index2 = j;
                }
            }
        }
        System.out.print("Số lớn nhất trong mảng 2 chiều là " + max + " tại vị trí " + index1 + index2);
    }
}
