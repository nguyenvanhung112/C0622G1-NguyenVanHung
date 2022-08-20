package bai_tap_lam_them.service.impl;


import bai_tap_lam_them.model.Student;
import bai_tap_lam_them.service.IStudentService;
import ulti_exception.*;

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
                        for (Student item : student1s
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
        return foundStudents;
    }

    private Student infoStudent() {
        int id;
        while (true) {
            try {
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
            } catch (NumberFormatException e) {
                System.out.println("ID không hợp lệ mời bạn nhập lại");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        String name;
        while (true) {
            try {
                System.out.print("Mời bạn nhập tên: ");
                name = scanner.nextLine();
                String str;
                for (int i = 0; i < name.length(); i++) {
                    str = "";
                    if ((str + name.charAt(i)).matches("\\d+")) {
                        throw new StringFormatException("Tên bạn không hợp lệ vui lòng nhập lại");
                    }
                }
                break;
            } catch (StringFormatException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Trường hợp ngoại lệ");
            }
        }
        String dateOfBirth;
        while (true) {
            try {
                System.out.print("Mời bạn nhập ngày sinh: ");
                dateOfBirth = scanner.nextLine();
                if (!dateOfBirth.matches("\\d+\\d+\\W+\\d+\\d+\\W+\\d+\\d+\\d+\\d")) {
                    throw new DateOfBirthException("Dữ liệu không đúng định dạng");
                }
                if (Integer.parseInt(dateOfBirth.substring(6)) > 2016) {
                    throw new DateOfBirthException("Dữ liệu không đúng định dạng");
                }
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        String sex;
        while (true) {
            try {
                System.out.print("Mời bạn nhập giới tính: ");
                sex = scanner.nextLine();
                if (!sex.equals("Nam") && (!sex.equals("Nữ"))) {
                    throw new GenderException("Dữ liệu bạn nhập không hợp lệ");
                }
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        double point;
        while (true) {
            try {
                System.out.print("Mời bạn nhập điểm: ");
                point = Double.parseDouble(scanner.nextLine());
                if (point < 0 || point > 100) {
                    throw new PointException("Bạn không thể nhập điểm nhỏ hơn 0 hoặc lớn hơn 100");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Bạn nhập không phải là số. Yêu cầu nhập lại.");
            } catch (PointException p) {
                System.err.println(p.getMessage());
            } catch (Exception e) {
                System.out.println("Trường hợp ngoại lệ");
            }
        }
        String nameClass;
        while (true) {
            try {
                System.out.print("Mời bạn nhập tên lớp: ");
                nameClass = scanner.nextLine();
                if (!nameClass.matches("\\D+\\d+\\d+\\d+\\d+\\D+\\d")) {
                    throw new NameClassException("Tên lớp không hợp lệ");
                }
                break;
            } catch (NameClassException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return new Student(id, name, dateOfBirth, sex, nameClass, point);
    }
}
