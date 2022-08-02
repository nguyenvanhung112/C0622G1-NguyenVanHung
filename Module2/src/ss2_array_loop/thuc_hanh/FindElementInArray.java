package ss2_array_loop.thuc_hanh;

import java.util.Scanner;

public class FindElementInArray {
    public static void main(String[] args) {
        String[] student = {"Hùng", "Danh", "Uy", "Đạt", "Tiến", "Châu", "Đức"};
        Scanner sc = new Scanner(System.in);
        System.out.printf("%s", "Nhập vào tên sinh viên \n");
        String name = sc.nextLine();
        boolean isExist = false;
        for (int i = 0; i < student.length; i++) {
            if (student[i].equals(name)) {
                System.out.printf("%s", "Vị trí của sinh viên" + name + " trong danh sách là " + i);
                isExist = true;
                break;
            }
        }
        if (!isExist) {
            System.out.printf("%s", "Không tìm thấy " + name + " trong danh sách");
        }
    }
}
