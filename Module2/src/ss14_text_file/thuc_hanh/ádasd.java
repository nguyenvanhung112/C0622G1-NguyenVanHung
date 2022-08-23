//package bai_tap_lam_them.controller;
//
//import bai_tap_lam_them.model.Student;
//import bai_tap_lam_them.ulti.ReadFileUlti;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class ádasd {
//    private ReadFileUlti ReadFile;
//
//    private List<Student> readFileStudent() {
//        List<String> studentList = ReadFile.readFile(PATH_NAME_FILE_ALL);
//        List<Student> students = new ArrayList<>();
//        if (studentList.size() == 0) {
//            System.out.println("Dữ liệu trong file không có");
//            return null;
//        } else {
//            String[] propertiesOfStudent;
//            Student student;
//            for (int i = 0; i < studentList.size(); i++) {
//                propertiesOfStudent = studentList.get(i).split(",");
//                if (propertiesOfStudent.length == 5) {
//                    student = new Student(Integer.parseInt(propertiesOfStudent[0]), propertiesOfStudent[1], propertiesOfStudent[2], Double.parseDouble(propertiesOfStudent[3]), propertiesOfStudent[4]);
//                    students.add(student);
//                }
//            }
//            return students;
//        }
//    }
//    private String convertStudentToString(Student student) {
//        return student.getId()+","+student.getName()+","+student.getDateOfBirth()+","+student.getPoint()+","+student.getNameClass();
//    }
//    private List<String> convertListStudentToListString(List<Student> students) {
//        List<String> strings = new ArrayList<>();
//        for(Student student: students) {
//            strings.add(convertStudentToString(student));
//        }
//        return strings;
//    }
//}
