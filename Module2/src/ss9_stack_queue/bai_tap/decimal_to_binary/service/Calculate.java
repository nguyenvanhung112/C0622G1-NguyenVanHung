package ss9_stack_queue.bai_tap.decimal_to_binary.service;

import java.util.ArrayList;
import java.util.Stack;

public class Calculate {
    public static void decimalToBinary() {
        Stack<Integer> stack = new Stack<>();
        int n = 8;
        while (n != 0) {
            stack.push(n % 2);
            n /= 2;
        }
        while (!stack.isEmpty()){
            System.out.print(stack.pop());
        }
    }
}
