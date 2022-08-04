package ss3_class_object.bai_tap.StopWatch;

import java.util.Arrays;



public class Main {
    public static void main(String[] args) {
        StopWatch sW = new StopWatch();
        System.out.print("Thời gian bắt đầu " + sW.start() + "\n");
        int[] array = new int[100000];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int)Math.floor(Math.random()*100000);
        }
        Arrays.sort(array);
        System.out.print("Mảng là " + Arrays.toString(array));
        System.out.print("\nThời gian kết thúc " + sW.stop());
        System.out.print("\nThời gian đếm được bằng mili giây là " + sW.getElapsedTime());
    }
}
