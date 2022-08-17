package bai_tap_lam_them.controller;


import bai_tap_lam_them.service.ITeacherService;
import bai_tap_lam_them.service.impl.TeacherService;

import java.util.Scanner;

public class TeacherController {
    private static Scanner scanner = new Scanner(System.in);
    private ITeacherService teacherService = new TeacherService();

    public void menuManagementTeacher() {
        while (true) {
            System.out.println("---------------------------------------------");
            System.out.println("Chào mừng bạn đến với CODEGYM");
            System.out.println("1. Hiển thị danh sách giảng viên");
            System.out.println("2. Thêm mới giảng viên");
            System.out.println("3. Xóa giảng viên");
            System.out.println("4. Tìm giảng viên");
            System.out.println("5. Exit");
            System.out.print("Mời bạn nhập chức năng 1 -> 5: ");
            int choice2 = Integer.parseInt(scanner.nextLine());
            switch (choice2) {
                case 1:
                    teacherService.displayAllTeacher();
                    break;
                case 2:
                    teacherService.addTeacher();
                    break;
                case 3:
                    teacherService.removeTeacher();
                    break;
                case 4:
                    teacherService.searchTeacher();
                case 5:
                    return;
                default:
                    System.out.println("Lựa chọn bạn nhập không đúng!");
            }
        }
    }
}