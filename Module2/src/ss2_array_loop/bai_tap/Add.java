package ss2_array_loop.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class Add {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9};
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập vào số muốn thêm");
        int number = sc.nextInt();
        System.out.print("Nhập ví trị muốn thêm vào");
        int index = sc.nextInt();
        for (int i = array.length-1; i <index ; i--) {
                array[i] = array[i-1];
        }
        array[index] = number;
        System.out.print(Arrays.toString(array));
    }
}
