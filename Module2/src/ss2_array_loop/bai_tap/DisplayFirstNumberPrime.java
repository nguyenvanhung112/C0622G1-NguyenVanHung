package ss2_array_loop.bai_tap;


public class DisplayFirstNumberPrime {
    public static void main(String[] args) {
        int check = 0;
        for (int i = 2; i < 100; i++) {
            int count = 0;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    count++;
                }
            }
            if (count == 0) {
                System.out.println(i);
                check++;
            }
            if (check == 20) {
                break;
            }
        }
    }
}
