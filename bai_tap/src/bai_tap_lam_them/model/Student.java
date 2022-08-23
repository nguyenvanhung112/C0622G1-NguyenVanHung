package bai_tap_lam_them.model;

public class Student extends Person {
    private double point;
    private String nameClass;

    public Student() {
    }


    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s,%s", this.getId(), this.getName(), this.getDateOfBirth(), this.getSex(), nameClass, point);
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

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }

    public String getNameClass() {
        return nameClass;
    }

    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }
}
