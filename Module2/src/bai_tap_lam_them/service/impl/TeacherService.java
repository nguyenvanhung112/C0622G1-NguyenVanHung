package bai_tap_lam_them.service.impl;


import bai_tap_lam_them.model.Teacher;
import bai_tap_lam_them.service.ITeacherService;
import bai_tap_lam_them.ulti.ReadFileUlti;
import ulti_exception.DateOfBirthException;
import ulti_exception.GenderException;
import ulti_exception.QualificationException;
import ulti_exception.StringFormatException;

import java.io.IOException;
import java.util.*;

import static bai_tap_lam_them.ulti.WriteFileUlti.writeFile;

public class TeacherService implements ITeacherService {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Teacher> teachers = new ArrayList<>();
    public final String PATH_NAME_FILE_TEACHER = "src\\bai_tap_lam_them\\service\\data\\teacher.txt";


    @Override
    public void displayAllTeacher() throws IOException {
        sortID();
        for (Teacher teacher : teachers
        ) {
            System.out.println(teacher);
        }
    }

    private void sortID() throws IOException {
        teachers = readTeacherFile(PATH_NAME_FILE_TEACHER);
        boolean isSwap = true;
        Teacher temp;
        for (int i = 0; i < Objects.requireNonNull(teachers).size() - 1 && isSwap; i++) {
            isSwap = false;
            for (int j = 0; j < teachers.size() - 1 - i; j++) {
                if (teachers.get(j).getName().compareTo(teachers.get(j + 1).getName()) > 0) {
                    isSwap = true;
                    temp = teachers.get(j + 1);
                    teachers.set(j + 1, teachers.get(j));
                    teachers.set(j, temp);
                }
            }
        }
        writeTeacherFile(PATH_NAME_FILE_TEACHER, teachers);
    }

    @Override
    public void addTeacher() throws IOException {
        Teacher teacher = this.infoTeacher();
        teachers.add(teacher);
        System.out.println("Thêm mới giảng viên thành công");
        writeTeacherFile(PATH_NAME_FILE_TEACHER, teachers);
    }

    @Override
    public void removeTeacher() throws IOException {
        readTeacherFile(PATH_NAME_FILE_TEACHER);
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
        writeTeacherFile(PATH_NAME_FILE_TEACHER, teachers);
        System.out.println("Danh sách hiện tại: \n");
        displayAllTeacher();
    }

    @Override
    public void searchTeacher() throws IOException {
        teachers = readTeacherFile(PATH_NAME_FILE_TEACHER);
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
                    List<Teacher> teacher1s = this.findTeacherName();
                    if (teacher1s.isEmpty()) {
                        System.out.println("Không tìm thấy");
                    } else {
                        for (Teacher item : teacher1s
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

    private List<Teacher> findTeacherName() throws IOException {
        teachers = readTeacherFile(PATH_NAME_FILE_TEACHER);
        List<Teacher> foundTeachers = new LinkedList<>();
        System.out.println("Mời bạn nhập tên");
        String name = scanner.nextLine();
        for (Teacher teacher : teachers) {
            if (teacher.getName().contains(name)) {
                foundTeachers.add(teacher);
            }
        }
        return foundTeachers;
    }


    private Teacher findTeacherID() throws IOException {
        teachers = readTeacherFile(PATH_NAME_FILE_TEACHER);
        System.out.print("Mời bạn nhập vào id: ");
        int id = Integer.parseInt(scanner.nextLine());
        for (Teacher teacher : teachers) {
            if (teacher.getId() == id) {
                return teacher;
            }
        }
        return null;
    }

    private Teacher infoTeacher() throws IOException {
        teachers = readTeacherFile(PATH_NAME_FILE_TEACHER);
        int id = this.checkID();
//        while (true) {
//            try {
//                System.out.print("Mời bạn nhập id: ");
//                id = Integer.parseInt(scanner.nextLine());
//                boolean check = true;
//                for (Teacher teacher : teachers) {
//                    if (teacher.getId() == id) {
//                        System.out.println("ID bị trùng, mời bạn nhập lại id");
//                        id = Integer.parseInt(scanner.nextLine());
//                        check = false;
//                        break;
//                    }
//                }
//                if (check) break;
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
                name = (scanner.nextLine());
                String str;
                for (int i = 0; i < name.length(); i++) {
                    str = "";
                    if ((str + name.charAt(i)).matches("\\d+")) {
                        throw new StringFormatException("Tên bạn không hợp lệ vui lòng nhập lại");
                    }
                }

                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
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
                if (Integer.parseInt(dateOfBirth.substring(6)) > 2022) {
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
        String qualification;
        String qualificationStr;
        while (true) {
            try {
                System.out.print("Mời bạn nhập trình độ chuyên môn: ");
                qualification = scanner.nextLine();
                for (int i = 0; i < name.length(); i++) {
                    qualificationStr = "";
                    if ((qualificationStr + name.charAt(i)).matches("\\d+")) {
                        throw new QualificationException("Dữ liệu bạn nhập ko hợp lệ");
                    }
                }
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return new Teacher(id, name, dateOfBirth, sex, qualification);
    }

    private int checkID() throws IOException {
        teachers = readTeacherFile(PATH_NAME_FILE_TEACHER);
        int nextID;
        if (teachers.size() == 0) {
            return 1;
        } else {
            nextID = teachers.get(0).getId();
            for (Teacher teacher : teachers) {
                if (nextID < teacher.getId()) {
                    nextID = teacher.getId();
                }
            }
        }
        return nextID + 1;
    }

    public static List<Teacher> readTeacherFile(String path) throws IOException {
        List<String> strings = ReadFileUlti.readFile(path);
        List<Teacher> teachers = new ArrayList<>();
        if (strings.size() == 0) {
            System.out.println("Dữ liệu trong file không có");
            return null;
        } else {
            String[] info;
            Teacher teacher;
            for (String string : strings) {
                info = string.split(",");
                if (info.length == 5) {
                    teacher = (new Teacher(Integer.parseInt(info[0]), info[1], info[2], info[3], info[4]));
                    teachers.add(teacher);
                }
            }
            return teachers;
        }
    }

    //    private String convertStudentToString(Teacher teacher) {
//        return teacher.getId() + "," + teacher.getName() + "," + teacher.getDateOfBirth() + "," + teacher.getSex() + "," + teacher.getQualification();
//    }
//
//    private List<String> convertListStudentToListString(List<Teacher> teachers) {
//        List<String> strings = new ArrayList<>();
//        for (Teacher teacher : teachers) {
//            strings.add(convertStudentToString(teacher));
//        }
//        return strings;
//    }
    public static void writeTeacherFile(String path, List<Teacher> teachers) throws IOException {
        String data = "";
        for (Teacher teacher : teachers) {
            data += teacher.toString();
            data += "\n";
        }
        writeFile(path, data);
    }
}
