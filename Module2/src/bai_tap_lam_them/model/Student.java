package bai_tap_lam_them.model;

public class Student extends Person {
    private double point;
    private String nameClass;

    public Student() {
    }



    @Override
    public String toString() {
        return "Student{" +
                " ID = " + getId() +
                " Name =" + getName() +
                " Date of Birth = " + getDateOfBirth() +
                " Sex = " + getSex() +
                " point = " + point +
                " ,nameClass = '" + nameClass +
                "} ";
    }

    public Student(double point, String nameClass) {
        this.point = point;
        this.nameClass = nameClass;
    }



    public Student(int id, String name, String dateOfBirth, String sex, String nameClass, double point) {
        super(id, name, dateOfBirth, sex);
        this.point = point;
        this.nameClass = nameClass;
    }
}
