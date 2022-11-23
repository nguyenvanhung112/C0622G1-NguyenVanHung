package ss2_array_loop.bai_tap;

import java.util.Arrays;

public class giaithuat {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};


        if (arr.length %2 !=0){
            int row = arr.length/2 + 1;
            int colums = 2;
            int[][] arr2 = new int[row][colums];
            for (int i = 0; i < arr.length; i++) {
               for (int j = 0; j < row; j++){
                   for(int k = 0; k < colums; k++){
                       arr2[j][k] = arr[i];
                   }
               }
            }
            System.out.println( Arrays.deepToString(arr2));
        }
    }
}
