public class Giaithuat {
    public static void main(String[] args) {
            int num, n;
           num = 5;
            n = num;
            for (int r = 0; r <= num; r++) {
                if (r==num){
                continue;}
                for (int sp = 1; sp <= r; sp++) {
                    System.out.print(" ");
                }
                for (int c = 1; c <= n; c++) {
                    System.out.print("*");
                }
                for (int c = num - r; c >= 1; c--) {
                    System.out.print("*");
                }

                n--;
                System.out.println();
            }

            for (int r = 2; r <= num+1; r++) {
                for (int sp = num - r+1; sp >= 1; sp--) {
                    System.out.print(" ");
                }
                for (int c = 1; c <= r; c++) {
                    System.out.print("*");
                }
                for (int c = r - 2; c >= 1; c--) {
                    System.out.print("*");
                }
                System.out.println();
            }
    }
}
