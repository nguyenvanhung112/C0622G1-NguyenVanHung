package bai_tap_lam_them.service.impl;


import bai_tap_lam_them.model.Student;
import bai_tap_lam_them.model.Teacher;
import bai_tap_lam_them.service.ITeacherService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TeacherService implements ITeacherService {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Teacher> teachers = new ArrayList<>();

    static {
        teachers.add(new Teacher(1, "nguyen van quang", "12/02/1990", "nam", "tutor"));
        teachers.add(new Teacher(2, "nguyen van hai", "11/02/1995", "nam", "tutor"));
    }

    @Override
    public void displayAllTeacher() {
        for (Teacher teacher : teachers
        ) {
            System.out.println(teacher);
        }
    }

    @Override
    public void addTeacher() {
        Teacher teacher = this.infoTeacher();
        teachers.add(teacher);
        System.out.println("Thêm mới giảng viên thành công");
    }

    @Override
    public void removeTeacher() {
        Teacher teacher = this.findTeacherID();
        if (teacher == null) {
            System.out.println("Không tìm thấy đối tượng cần xóa");
        } else {
            System.out.println("Bạn có thực sự muốn xóa giảng viên có ID " + teacher.getId() + " không?");
            System.out.println("1 . Có");
            System.out.println("2 . Không");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 1) {
                teachers.remove(teacher);
                System.out.println("Xóa thành công");

            }
        }
        System.out.println("Danh sách hiện tại: \n");
        displayAllTeacher();
    }

    @Override
    public void searchTeacher() {
        while (true) {
            System.out.println("1. Tìm theo ID");
            System.out.println("2. Tìm theo tên");
            System.out.println("3. Thoát");
            System.out.println("Mời bạn nhập chức năng");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    Teacher teacher = this.findTeacherID();
                    if (teacher == null) {
                        System.out.println("Không tìm thấy");
                    } else {
                        System.out.println(teacher);
                    }
                    break;
                case 2:
                    Teacher teacher1 = this.findTeacherName();
                    if (teacher1 == null) {
                        System.out.println("Không tìm thấy");
                    } else {
                        System.out.println(teacher1);
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

    private Teacher findTeacherName() {
        System.out.println("Mời bạn nhập tên");
        String name = scanner.nextLine();
        for (Teacher teacher : teachers) {
            if (teacher.getName().contains(name)) {
                return teacher;
            }
        }
        return null;
    }



    private Teacher findTeacherID() {
        System.out.print("Mời bạn nhập vào id: ");
        int id = Integer.parseInt(scanner.nextLine());
        for (Teacher teacher : teachers) {
            if (teacher.getId() == id) {
                return teacher;
            }
        }
        return null;
    }

    private Teacher infoTeacher() {
        int id;
        do {
            System.out.print("Mời bạn nhập id: ");
            id = Integer.parseInt(scanner.nextLine());
            boolean isCheck = true;
            for (Teacher teacher : teachers) {
                if (teacher.getId() == id) {
                    System.out.println("ID bị trùng, mời bạn nhập lại");
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
        System.out.print("Mời bạn nhập trình độ chuyên môn: ");
        String qualification = scanner.nextLine();
        Teacher teacher = new Teacher(id, name, dateOfBirth, sex, qualification);
        return teacher;
    }
}
