package ss2_array_loop.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class Delete {
    public static void main(String[] args) {
        int[] array = {8, 2, 6, 64, 4, 76, 6, 45, 15, 10};
        System.out.print(Arrays.toString(array));
        Scanner sc = new Scanner(System.in);
        System.out.print("\nNhập vào số muốn xóa\n");
        int number = sc.nextInt();
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != number) {
                array[index] = array[i];
                index++;
            }
        }
        array[array.length - 1] = 0;
        System.out.print("Mảng sau khi xóa phần tử là " + Arrays.toString(array));
    }
}
