package bai_tap_lam_them.service.impl;


import bai_tap_lam_them.model.Student;
import bai_tap_lam_them.service.IStudentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentService implements IStudentService {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Student> students = new ArrayList<>();

    static {
        students.add(new Student(1, "nguyen van hùng", "11/02/1996", "nam", "C06", 8));
        students.add(new Student(2, "nguyen van danh", "23/04/2000", "nam", "C06", 9));
    }


    @Override
    public void addStudent() {
        Student student = this.infoStudent();
        students.add(student);
        System.out.println("Thêm mới học viên thành công");
    }

    @Override
    public void displayAllStudent() {
        for (Student student : students
        ) {
            System.out.println(student);
        }
    }

    @Override
    public void removeStudent() {
        Student student = this.findStudentID();
        if (student == null) {
            System.out.println("Không tìm thấy đối tượng cần xóa");
        } else {
            System.out.println("Bạn có thực sự muốn xóa học viên có ID " + student.getId() + " không?");
            System.out.println("1 . Có");
            System.out.println("2 . Không");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 1) {
                students.remove(student);
                System.out.println("Xóa thành công");
            }
        }
    }

    private Student findStudentID() {
        System.out.print("Mời bạn nhập vào id: ");
        int id = Integer.parseInt(scanner.nextLine());
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    public void searchStudent() {

        while (true) {
            System.out.println("1. Tìm theo ID");
            System.out.println("2. Tìm theo tên");
            System.out.println("3. Thoát");
            System.out.println("Mời bạn nhập chức năng");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    Student student = this.findStudentID();
                    if (student == null) {
                        System.out.println("Không tìm thấy");
                    } else {
                        System.out.println(student);
                    }
                    break;
                case 2:
                    Student student1 = this.findStudentName();
                    if (student1 == null) {
                        System.out.println("Không tìm thấy");
                    } else {
                        System.out.println(student1);
                    }
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Nhập lại");
                    break;
            }
        }
    }

    private Student findStudentName() {
        System.out.println("Mời bạn nhập tên");
        String name = scanner.nextLine();
        for (Student student : students) {
            if (student.getName().contains(name)) {
                return student;
            }
        }
        return null;
    }

    private Student infoStudent() {
        int id;
        do {
            System.out.print("Mời bạn nhập id: ");
            id = Integer.parseInt(scanner.nextLine());
            boolean isCheck = true;
            for (Student student : students) {
                if (student.getId() == id) {
                    System.out.println("ID bị trùng mời bạn nhập lại");
                    isCheck = false;
                    break;
                }
            }
            if (isCheck) break;
        } while (true);
        System.out.print("Mời bạn nhập tên: ");
        String name = scanner.nextLine();
        System.out.print("Mời bạn nhập ngày sinh: ");
        String dateOfBirth = scanner.nextLine();
        System.out.print("Mời bạn nhập giới tính: ");
        String sex = scanner.nextLine();
        System.out.print("Mời bạn nhập điểm: ");
        double point = Double.parseDouble(scanner.nextLine());
        System.out.print("Mời bạn nhập tên lớp: ");
        String nameClass = scanner.nextLine();
        Student student = new Student(id, name, dateOfBirth, sex, nameClass, point);
        return student;
    }
}
