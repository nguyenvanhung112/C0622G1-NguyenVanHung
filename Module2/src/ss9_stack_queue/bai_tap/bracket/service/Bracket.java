package ss9_stack_queue.bai_tap.bracket.service;

import java.util.Stack;

public class Bracket {
    public static boolean checkBracket(String string){
            Stack<Character> stack = new Stack<>();
            char[] charArr = string.toCharArray();
            for (char sym : charArr) {
                if (sym == '(') {
                    stack.push(sym);
                } else if (sym == ')') {
                    if (stack.isEmpty()) {
                        return false;
                    } else {
                        stack.pop();
                    }
                }
            }
            if (stack.isEmpty()) {
                return true;
            } else {
                return false;
            }
    }
}
