package introduction_java.bai_tap;

import java.util.Scanner;

public class NumberToWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number ");
        int number = scanner.nextInt();
        if (number > 10 && number < 20) {
            switch (number) {
                case 11:
                    System.out.println("eleven");
                    break;
                case 12:
                    System.out.println("twelve");
                    break;
                case 13:
                    System.out.println("thirteen");
                    break;
                case 14:
                    System.out.println("fourteen");
                    break;
                case 15:
                    System.out.println("fifteen");
                    break;
                case 16:
                    System.out.println("sixteen");
                    break;
                case 17:
                    System.out.println("seventeen");
                    break;
                case 18:
                    System.out.println("eighteen");
                    break;
                case 19:
                    System.out.println("nineteen");
                    break;
            }
            if (number >= 20 && number < 1001) {
                String number1 = "";
                String number2 = "";
                String number3 = "";
                String number4 = "";
                switch (number / 100) {
                    case 1:
                        number1 = "one hundred";
                        break;
                    case 2:
                        number1 = "two hundred";
                        break;
                    case 3:
                        number1 = "three hundred";
                        break;
                    case 4:
                        number1 = "four hundred";
                        break;
                    case 5:
                        number1 = "five hundred";
                        break;
                    case 6:
                        number1 = "six hundred";
                        break;
                    case 7:
                        number1 = "seven hundred";
                        break;
                    case 8:
                        number1 = "eight hundred";
                        break;
                    case 9:
                        number1 = "nice hundred";
                        break;
                }
                switch (number % 100 / 10) {
                    case 1:
                        number2 = "ten";
                        break;
                    case 2:
                        number2 = "twenty";
                        break;
                    case 3:
                        number2 = "thirty";
                        break;
                    case 4:
                        number2 = "forty";
                        break;
                    case 5:
                        number2 = "fifty";
                        break;
                    case 6:
                        number2 = "sixty";
                        break;
                    case 7:
                        number2 = "seventy";
                        break;
                    case 8:
                        number2 = "eighty";
                        break;
                    case 9:
                        number2 = "nicety";
                        break;
                }

                switch (number % 10) {
                    case 1:
                        number4 = "one";
                        break;
                    case 2:
                        number4 = "two";
                        break;
                    case 3:
                        number4 = "three";
                        break;
                    case 4:
                        number4 = "four";
                        break;
                    case 5:
                        number4 = "five";
                        break;
                    case 6:
                        number4 = "six";
                        break;
                    case 7:
                        number4 = "seven";
                        break;
                    case 8:
                        number4 = "eight";
                        break;
                    case 9:
                        number4 = "nice";
                        break;
                }


                System.out.println(number1 + " and " + number2 + " " + number4);
            }
        }
    }
}
