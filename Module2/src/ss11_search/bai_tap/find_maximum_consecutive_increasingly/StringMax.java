package ss11_search.bai_tap.find_maximum_consecutive_increasingly;

import java.util.LinkedList;
import java.util.Scanner;

public class StringMax {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào chuỗi");
        String str = scanner.nextLine();
        LinkedList<Character> list = new LinkedList<>();
        LinkedList<Character> max = new LinkedList<>();
        for (int i = 0; i < str.length() ; i++) {
            if (list.size() > 1 && str.charAt(i) <= list.getLast() && list.contains(str.charAt(i))){
                list.clear();
            }
            list.add(str.charAt(i));
            if (list.size() > max.size()){
                max.clear();
                max.addAll(list);
            }
        }
        for (Character item: max
             ) {
            System.out.print(item);
        }
    }
}
