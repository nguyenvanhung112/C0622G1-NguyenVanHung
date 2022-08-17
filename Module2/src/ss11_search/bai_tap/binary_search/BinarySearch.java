package ss11_search.bai_tap.binary_search;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào độ dài của mảng");
        int size = Integer.parseInt(scanner.nextLine());
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.println("Nhập vào phần tử " + (i + 1) + " vào mảng");
            array[i] = Integer.parseInt(scanner.nextLine());
        }
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        System.out.println("Nhập vào số cần tìm");
        int value = Integer.parseInt(scanner.nextLine());
        int result = binarySearch(array, 0, array.length - 1, value);
        if (result == -1) {
            System.out.println("Không tìm thấy em");
        } else {
            System.out.println("Vị trí của em là " + result);
        }
    }

    public static int binarySearch(int[] array, int left, int right, int value) {
        if (right >= left) {
            int mid = (left + right) / 2;
            if (value == array[mid]) {
                return mid;
            }
            if (value > array[mid]) {
                return binarySearch(array, mid + 1, right, value);
            }
            return binarySearch(array, left, right - 1, value);
        }
        return -1;
    }
}
