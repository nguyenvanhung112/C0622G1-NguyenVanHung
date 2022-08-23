package bai_tap_lam_them.controller;

import bai_tap_lam_them.service.IStudentService;
import bai_tap_lam_them.service.ITeacherService;
import bai_tap_lam_them.service.impl.StudentService;
import bai_tap_lam_them.service.impl.TeacherService;

import java.io.IOException;
import java.util.Scanner;

public class MemberController {
    Scanner scanner = new Scanner(System.in);
    //    StudentController studentController = new StudentController();
//    TeacherController teacherController = new TeacherController();
    private IStudentService studentService = new StudentService();
    private ITeacherService teacherService = new TeacherService();

    public void menuManagement() throws IOException {
        while (true) {
            System.out.println("_____________________________________________________");
            System.out.println("1. Quản lí giảng viên");
            System.out.println("2. Quản lí sinh viên");
            System.out.println("Mời bạn nhập chức năng");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
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
                            break;
                        case 5:
                            break;
                        default:
                            System.out.println("Lựa chọn bạn nhập không đúng!");
                    }
                    break;
                case 2:
                    System.out.println("---------------------------------------------");
                    System.out.println("Chào mừng bạn đến với CODEGYM");
                    System.out.println("1. Hiển thị danh sách học viên");
                    System.out.println("2. Thêm mới học viên");
                    System.out.println("3. Xóa học viên");
                    System.out.println("4. Tìm học viên");
                    System.out.println("5. Exit");
                    System.out.print("Mời bạn nhập chức năng 1 -> 5: ");
                    int choice1 = Integer.parseInt(scanner.nextLine());
                    switch (choice1) {
                        case 1:
                            studentService.displayAllStudent();
                            break;
                        case 2:
                            studentService.addStudent();
                            break;
                        case 3:
                            studentService.removeStudent();
                            break;
                        case 4:
                            studentService.searchStudent();
                            break;
                        case 5:
                            break;
                        default:
                            System.out.println("Lựa chọn bạn nhập không đúng!");
                    }
                    break;
                default:
                    System.out.println("Nhập lại chức năng");
            }
        }
    }
}
