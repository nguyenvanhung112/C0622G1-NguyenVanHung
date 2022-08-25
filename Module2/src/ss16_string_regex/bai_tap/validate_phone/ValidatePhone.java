package ss16_string_regex.bai_tap.validate_phone;


import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatePhone {
    private static final String ACCOUNT_REGEX = "^[(][0-9]{2}[)][-][(][0][0-9]{8}[)]$";

    public ValidatePhone() {
    }

    public boolean validate(String regex) {
        Pattern pattern = Pattern.compile(ACCOUNT_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào số điện thoại");
        String phone = scanner.nextLine();
        ValidatePhone validatePhone = new ValidatePhone();
        boolean isvalid = validatePhone.validate(phone);
        System.out.println("Phone is " + isvalid);
    }
}
