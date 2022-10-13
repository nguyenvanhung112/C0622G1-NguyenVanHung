package ss2_array_loop.thuc_hanh;

import java.util.*;

public class timso {
    public static boolean isPrimeNumber(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 8, 43}, {9, 4, 53, 7}, {11, 6, 4, 0}, {1, 2, 6, 51}};
        Set<Integer> arr1 = new TreeSet<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (isPrimeNumber(arr[i][j])) {
                    arr1.add(arr[i][j]);
                }
            }
        }
        System.out.println(arr1);
    }
}
