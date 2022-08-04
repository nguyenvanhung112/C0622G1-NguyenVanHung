package ss1_introduction_java.thuc_hanh;
class EmptyRhombusNumbers {
    public static void main(String[] args) {
        int n = 4;
        for (int i = -n; i <= n; i++) {
            int iAbs = Math.abs(i);
            for (int j = - n - 1; j <= n; j++) {
                int jAbs = Math.abs(j);
                System.out.print(iAbs + jAbs == n + 1  ? jAbs : " ");
                if (j < n) {
                    System.out.print(" ");
                } else {
                    System.out.println();
                }
            }
        }
    }
}