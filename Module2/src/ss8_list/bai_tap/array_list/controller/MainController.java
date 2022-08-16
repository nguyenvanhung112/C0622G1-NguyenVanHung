package ss8_list.bai_tap.array_list.controller;

import ss4_access_modifier.bai_tap.Student.Student;
import ss8_list.bai_tap.array_list.model.MyArrayList;
import ss8_list.thuc_hanh.simple_list.model.MyList;

import java.util.Arrays;

public class MainController {
    public static class Students {
        private int id;
        private String name;

        public Students() {

        }

        public Students(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        Students students1 = new Students(1, "Hoàng");
        Students students2 = new Students(2, "Hùng");
        Students students3 = new Students(3, "Châu");
        Students students4 = new Students(4, "Tiến");
        Students students5 = new Students(5, "huy");
        Students students6 = new Students(6,"Sáng");
        MyArrayList<Students> studentsMyArrayList = new MyArrayList<>();
        studentsMyArrayList.add(students1);
        studentsMyArrayList.add(students2);
        studentsMyArrayList.add(students3);
        studentsMyArrayList.add(students4);
        studentsMyArrayList.add(students5, 1);
//        studentsMyArrayList.remove();
        System.out.println(studentsMyArrayList.toString());
        System.out.println(studentsMyArrayList.get(2).getId());
        System.out.println(studentsMyArrayList.indexOf(students1));
        for (int i = 0; i < studentsMyArrayList.size(); i++) {
           Students students = (Students) studentsMyArrayList.elements[i];
           System.out.println(students.getId());
           System.out.println(students.getName());
       }

//        System.out.println(studentsMyArrayList.contains(students6));
        MyArrayList<Students> newArray;
        newArray = studentsMyArrayList.clone();
        for (int i = 0; i < newArray.size(); i++) {
            System.out.println(newArray.get(i).getId());
        }
    }
}
