package bai_tap_lam_them.service.impl;


import bai_tap_lam_them.model.Student;
import bai_tap_lam_them.service.IStudentService;

import java.util.ArrayList;
import java.util.LinkedList;
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
        sort();
        for (Student item : students) {
            System.out.println(item);
        }
    }

    private void sort() {
        boolean isSwap = true;
        Student temp;
        for (int i = 0; i < students.size() - 1 && isSwap; i++) {
            isSwap = false;
            for (int j = 0; j < students.size() - 1 - i; j++) {
                if (students.get(j).getName().compareTo(students.get(j + 1).getName()) > 0) {
                    isSwap = true;
                    temp = students.get(j + 1);
                    students.set(j + 1, students.get(j));
                    students.set(j, temp);

                }

            }

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
                    List<Student> student1s = this.findStudentName();
                    if (student1s.isEmpty()) {
                        System.out.println("Không tìm thấy");
                    } else {
                        for (Student item: student1s
                             ) {
                            System.out.println(item);
                        }
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

    private List<Student> findStudentName() {
        List<Student> foundStudents = new LinkedList<>();
        System.out.println("Mời bạn nhập tên");
        String name = scanner.nextLine();
        for (Student student : students) {
            if (student.getName().contains(name)) {
                foundStudents.add(student);
            }
        }
        return  foundStudents;
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
