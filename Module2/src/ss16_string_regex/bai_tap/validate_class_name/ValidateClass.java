package ss16_string_regex.bai_tap.validate_class_name;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateClass {
    private static final String ACCOUNT_REGEX = "^[CAP][0-9]{4}[GHIKLM]$";

    public ValidateClass() {
    }
    public boolean validate(String regex) {
        Pattern pattern = Pattern.compile(ACCOUNT_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
            System.out.println("Nhập vào tên class");
            String className = scanner.nextLine();
            ValidateClass validateClass = new ValidateClass();
            boolean isvalid = validateClass.validate(className);
            System.out.println("Class is " + isvalid);

    }
}
