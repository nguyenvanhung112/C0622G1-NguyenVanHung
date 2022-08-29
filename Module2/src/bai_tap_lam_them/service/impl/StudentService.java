package bai_tap_lam_them.service.impl;


import bai_tap_lam_them.model.Student;
import bai_tap_lam_them.model.Teacher;
import bai_tap_lam_them.service.IStudentService;
import bai_tap_lam_them.ulti.ReadFileUlti;
import ulti_exception.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static bai_tap_lam_them.ulti.WriteFileUlti.writeFile;

public class StudentService implements IStudentService {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Student> students = new ArrayList<>();
    public final String PATH_NAME_FILE_STUDENT = "src\\bai_tap_lam_them\\service\\data\\student.txt";

    @Override
    public void addStudent() throws IOException {
        Student student = this.infoStudent();
        students.add(student);
        System.out.println("Thêm mới học viên thành công");
//        WriteFileUlti.writeFile(PATH_NAME_FILE_ALL, true, convertListStudentToListString(students));
        writeStudentFile(PATH_NAME_FILE_STUDENT, students);
    }

    @Override
    public void displayAllStudent() throws IOException {
        sort();
        for (Student item : students) {
            System.out.println(item);
        }
    }

    private void sort() throws IOException {
        students = readStudentFile(PATH_NAME_FILE_STUDENT);
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
        writeStudentFile(PATH_NAME_FILE_STUDENT, students);
//        WriteFileUlti.writeFile(PATH_NAME_FILE_ALL, true, convertListStudentToListString(students));
    }

    @Override
    public void removeStudent() throws IOException {
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
        writeStudentFile(PATH_NAME_FILE_STUDENT, students);
        System.out.println("Danh sách hiện tại:\n");
        displayAllStudent();
//        WriteFileUlti.writeFile(PATH_NAME_FILE_ALL, false, convertListStudentToListString(students));
    }

    private Student findStudentID() throws IOException {
        students = readStudentFile(PATH_NAME_FILE_STUDENT);
        System.out.print("Mời bạn nhập vào id: ");
        int id = Integer.parseInt(scanner.nextLine());
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    public void searchStudent() throws IOException {
        students = readStudentFile(PATH_NAME_FILE_STUDENT);
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

    private List<Student> findStudentName() throws IOException {
        students = readStudentFile(PATH_NAME_FILE_STUDENT);
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

    private Student infoStudent() throws IOException {
        students = readStudentFile(PATH_NAME_FILE_STUDENT);
        int id = this.getNewID();
//        while (true) {
//            try {
//                System.out.print("Mời bạn nhập id: ");
//                id = Integer.parseInt(scanner.nextLine());
//                boolean isCheck = true;
//                for (Student student : students) {
//                    if (student.getId() == id) {
//                        System.out.println("ID bị trùng mời bạn nhập lại");
//                        isCheck = false;
//                        break;
//                    }
//                }
//                if (isCheck) break;
//            } catch (NumberFormatException e) {
//                System.out.println("ID không hợp lệ mời bạn nhập lại");
//            } catch (Exception e) {
//                System.out.println(e.getMessage());
//            }
//        }
        String name;

        while (true) {
            try {
                System.out.print("Mời bạn nhập tên: ");
                name = scanner.nextLine();
                String str;
                for (int i = 0; i < name.length(); i++) {
                    str = "";
                    if ((str + name.charAt(i)).matches("\\d+")) {
                        throw new NameFormatException("Tên bạn không hợp lệ vui lòng nhập lại");
                    }
                }
                String[] name1 = name.split("");
                for (int i = 0; i < name1.length; i++) {
                    if ((name1[i].equals(" ")) && (name1[i + 1].equals(" "))) {
                        throw new NameFormatException("Tên bạn không hợp lệ vui lòng nhập lại");
                    }
                }
                if (!checkName(name)) {
                    throw new NameFormatException("Tên bạn không hợp lệ vui lòng nhập lại");
                }
                break;
            } catch (NameFormatException e) {
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
                if (!checkClassName(nameClass)) {
                    throw new NameClassException("Tên lớp không hợp lệ");
                }
//                if (!nameClass.matches("\\D+\\d+\\d+\\d+\\d+\\D+\\d")) {
//                    throw new NameClassException("Tên lớp không hợp lệ");
//                }
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return new Student(id, name, dateOfBirth, sex, nameClass, point);
    }

    public boolean checkClassName(String regex) {
        Pattern pattern = Pattern.compile("[AC][0-9]{4}[GI][1]");
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    public boolean checkName(String regex) {
        Pattern pattern = Pattern.compile("[A-Z a-zvVxXyYỳọáầảấờễàạằệếýộậốũứĩõúữịỗìềểẩớặòùồợãụủíỹắẫựỉỏừỷởóéửỵẳẹèẽổẵẻỡơôưăêâđĐ]{5,50}");
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    private int getNewID() throws IOException {
        students = readStudentFile(PATH_NAME_FILE_STUDENT);
        int nextID;
        if (students.size() == 0) {
            return 1;
        } else {
            nextID = students.get(0).getId();
            for (Student student : students) {
                if (nextID < student.getId()) {
                    nextID = student.getId();
                }
            }
        }
        return nextID + 1;
    }

    public static List<Student> readStudentFile(String path) throws IOException {
        List<String> strings = ReadFileUlti.readFile(path);
        List<Student> students = new ArrayList<>();

        String[] info;
        for (String line : strings) {
            info = line.split(",");
            if (info.length == 6) {
                students.add(new Student(Integer.parseInt(info[0]), info[1], info[2], info[3], info[4], Double.parseDouble(info[5])));
            }
        }
        return students;
    }

    public static void writeStudentFile(String path, List<Student> students) throws IOException {
        String data = "";
        for (Student student : students) {
            data += student.toString();
            data += "\n";
        }
        writeFile(path, data);
    }
}
