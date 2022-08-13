package bai_tap_lam_them.service.impl;


import bai_tap_lam_them.model.Teacher;
import bai_tap_lam_them.service.ITeacherService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TeacherService implements ITeacherService {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Teacher> teachers = new ArrayList<>();

    static {
        teachers.add(new Teacher(1, "quang", "12/02/1990", "nam", "tutor"));
        teachers.add(new Teacher(2, "hai", "11/02/1995", "nam", "tutor"));
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
        Teacher teacher = this.findTeacher();
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

    private Teacher findTeacher() {
        System.out.print("Mời bạn nhập vào id cần xóa: ");
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
