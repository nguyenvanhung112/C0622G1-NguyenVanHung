package bai_tap_lam_them.view;

import bai_tap_lam_them.controller.StudentController;
import bai_tap_lam_them.controller.TeacherController;

import java.util.Scanner;

public class MainView {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentController studentController = new StudentController();
        TeacherController teacherController = new TeacherController();
        while (true) {
            System.out.println("1. Quản lí giảng viên");
            System.out.println("2. Quản lí sinh viên");
            System.out.println("Mời bạn nhập chức năng");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 1) {
                teacherController.menuManagementTeacher();
            } else if (choice == 2) {
                studentController.menuManagementStudent();
            }
        }
    }
}
