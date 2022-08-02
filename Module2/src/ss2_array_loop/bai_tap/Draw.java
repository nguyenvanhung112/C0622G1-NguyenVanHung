package ss2_array_loop.bai_tap;


public class Draw {
    public static void main(String[] args) {
        System.out.printf("In hình chữ nhật \n");
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 7; j++) {
                System.out.printf("*");
            }
            System.out.printf("\n");
        }
        System.out.printf("In hình tam giác vuông có cạnh góc vuông ở dưới \n");
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.printf("*");
            }
            System.out.printf("\n");
        }
        System.out.printf("In hình tam giác vuông có cạnh góc vuông ở trên \n");
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5; j++) {
                if (j >= i) {
                    System.out.printf("*");
                } else {
                    System.out.printf(" ");
                }
            }
            System.out.printf("\n");
        }
        System.out.printf("In hình tam giác vuông cân \n");
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 10; j++) {
                if (j > (5 - i) && j < (5 + i)) {
                    System.out.printf("*");
                }else {
                    System.out.printf(" ");
                }
            }
            System.out.printf("\n");
        }

    }
}
