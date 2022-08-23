package bai_tap_lam_them.controller;//package bai_tap_lam_them.controller;
//
//
//import bai_tap_lam_them.service.IStudentService;
//import bai_tap_lam_them.service.impl.StudentService;
//
//import java.io.IOException;
//import java.util.Scanner;
//
//public class StudentController {
//    private static Scanner scanner = new Scanner(System.in);
//    private IStudentService studentService = new StudentService();
//
//    public void menuManagementStudent() throws IOException {
//        while (true) {
//            System.out.println("---------------------------------------------");
//            System.out.println("Chào mừng bạn đến với CODEGYM");
//            System.out.println("1. Hiển thị danh sách học viên");
//            System.out.println("2. Thêm mới học viên");
//            System.out.println("3. Xóa học viên");
//            System.out.println("4. Tìm học viên");
//            System.out.println("5. Exit");
//            System.out.print("Mời bạn nhập chức năng 1 -> 5: ");
//            int choice1 = Integer.parseInt(scanner.nextLine());
//            switch (choice1) {
//                case 1:
//                    studentService.displayAllStudent();
//                    break;
//                case 2:
//                    studentService.addStudent();
//                    break;
//                case 3:
//                    studentService.removeStudent();
//                    break;
//                case 4:
//                    studentService.searchStudent();
//                    break;
//                case 5:
//                    return;
//                default:
//                    System.out.println("Lựa chọn bạn nhập không đúng!");
//            }
//
//        }
//    }
//}
