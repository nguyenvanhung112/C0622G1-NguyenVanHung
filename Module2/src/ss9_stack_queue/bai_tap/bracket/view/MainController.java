package ss9_stack_queue.bai_tap.bracket.view;

import java.util.Scanner;

import static ss9_stack_queue.bai_tap.bracket.service.Bracket.checkBracket;

public class MainController {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào đây");
        String string = scanner.nextLine();
        System.out.println(checkBracket(string));
    }
}
