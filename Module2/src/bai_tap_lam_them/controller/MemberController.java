package bai_tap_lam_them.controller;

import bai_tap_lam_them.service.IStudentService;
import bai_tap_lam_them.service.ITeacherService;
import bai_tap_lam_them.service.impl.StudentService;
import bai_tap_lam_them.service.impl.TeacherService;

import java.io.IOException;
import java.util.Scanner;

public class MemberController {
    Scanner scanner = new Scanner(System.in);
    StudentController studentController = new StudentController();
    TeacherController teacherController = new TeacherController();
    public void menuManagement() throws IOException {
        while (true) {
            System.out.println("_____________________________________________________");
            System.out.println("1. Quản lí giảng viên");
            System.out.println("2. Quản lí sinh viên");
            System.out.println("Mời bạn nhập chức năng");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    teacherController.menuManagementTeacher();
                    break;
                case 2:
                    studentController.menuManagementStudent();
                    break;
                default:
                    System.out.println("Nhập lại chức năng");
            }
        }
    }
}
