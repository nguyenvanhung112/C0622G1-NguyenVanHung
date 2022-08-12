package bai_tap_lam_them.controller;

import java.util.Scanner;

public class MemberController {
    Scanner scanner = new Scanner(System.in);
    StudentController studentController = new StudentController();
    TeacherController teacherController = new TeacherController();

    public void menuManagement() {
        while (true) {
            System.out.println("1. Quản lí giảng viên");
            System.out.println("2. Quản lí sinh viên");
            System.out.println("Mời bạn nhập chức năng");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 1) {
                teacherController.menuManagementTeacher();
            } else if (choice == 2) {
                studentController.menuManagementStudent();
            }else {
                System.out.println("Nhập lại chức năng");
            }
        }
    }
}
