package ss9_stack_queue.bai_tap.palindrome.service;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class CheckString {
    public static boolean checkPalindrome(){
        String str = "Able was I ere I saw elba";
        String strLow = str.toLowerCase();
        char[] chars = strLow.toCharArray();
        Queue<Character> queues = new LinkedList<>();
        for (Character character: chars
             ) {
            queues.add(character);
        }
        Stack<Character> stacks = new Stack<>();
        for (Character character1 :chars) {
            stacks.push(character1);
        }
        StringBuilder queueString = new StringBuilder();
        StringBuilder stackString = new StringBuilder();
        char i;
        for ( i = 0; i < strLow.length(); i++) {
            queueString.append(queues.remove());
            stackString.append(stacks.pop());
        }

        return queueString.toString().equals(stackString.toString());
    }
}
