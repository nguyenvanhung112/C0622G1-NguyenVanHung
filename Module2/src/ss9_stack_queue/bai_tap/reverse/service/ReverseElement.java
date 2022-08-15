package ss9_stack_queue.bai_tap.reverse.service;


import java.util.Arrays;
import java.util.Stack;

public class ReverseElement {
    public static void reverseElement() {
        System.out.println("Đảo ngược phần tử trong mảng số nguyên sử dụng Stack");
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8};
        Stack<Integer> stack = new Stack<>();
        int i;
        for (i = 0; i < array.length; i++) {
            stack.push(array[i]);
        }
        System.out.println("Trước khi đảo");
        System.out.println(stack);
        int j;
        for (j = 0; j < array.length; j++) {
            array[j] = stack.pop();
        }
        System.out.println("Sau khi đảo");
        System.out.println(Arrays.toString(array));
        System.out.println("Đảo ngược chuỗi sử dụng Stack");
        String str = "abcdfgh";
        char[] chars = str.toCharArray();
        Stack<Character> stack1 = new Stack<>();
        char k;
        for (k = 0; k < chars.length; k++) {
            stack1.push(chars[k]);
        }
        System.out.println("Trước khi đảo");
        System.out.println(stack1);
        char h;
        for (h = 0; h < chars.length; h++) {
            chars[h] = stack1.pop();
        }
        System.out.println("Sau khi đảo");
        System.out.println(Arrays.toString(chars));
    }
}
