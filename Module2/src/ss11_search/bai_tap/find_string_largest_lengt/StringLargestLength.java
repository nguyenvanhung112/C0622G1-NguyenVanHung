package ss11_search.bai_tap.find_string_largest_lengt;

import java.util.LinkedList;
import java.util.Scanner;

public class StringLargestLength {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào 1 chuỗi: ");
        String str = scanner.nextLine();
        LinkedList<Character> max = new LinkedList<>();

        int i;
        for (i = 0; i < str.length(); i++) {
            LinkedList<Character> list = new LinkedList<>();
            list.add(str.charAt(i));
            int j;
            for (j = i + 1; j < str.length(); j++) {
                if (str.charAt(j) > list.getLast()) {
                    list.add(str.charAt(j));
                }
            }
            if (list.size() > max.size()) {
                max.clear();
                max.addAll(list);

            }
            list.clear();
        }
        for (Character item : max) {
            System.out.println(item);
        }
    }

}
