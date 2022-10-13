package ss2_array_loop.bai_tap;

import java.lang.reflect.Array;
import java.util.*;

public class CountOfCharacterInString {
    public static void main(String[] args) {
        String str = "abcbdccef";
//        Scanner sc = new Scanner(System.in);
//        System.out.print("Nhập vào giá trị\n");
//        char character = sc.nextLine().charAt(0);
//        int count = 0;
        String[] info = str.split("");
        List<String> c = new LinkedList<>();
        for (int i = 0; i < info.length; i++) {
            for(int j =i+1;j<info.length;j++){
            if (info[i].equals(info[j])) {
                if (!c.contains(info[i])){
                c.add(info[i]);
                }
            }
          }
        }
        System.out.println(c);
    }
}
