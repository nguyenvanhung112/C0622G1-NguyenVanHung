package ss2_array_loop.bai_tap;

import java.util.Scanner;

public class SumOfNumbersDiagonal {
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

        int[][] array = new int[row][columns];
        int i;
        int j;
        for (i = 0; i < row; i++) {
            for (j = 0; j < columns; j++) {
                System.out.print("Nhập vào phần tử " + i + j + "\n");
                array[i][j] = Integer.parseInt(sc.nextLine());
            }
        }
        int sum = 0;
        for (i = 0; i < row; i++) {
            for (j = 0; j < columns; j++) {
                if (i == j) {
                    sum += array[i][j];
                }
            }
        }
        System.out.print("Tổng các số ở đường chéo là: " + sum);
    }
}
