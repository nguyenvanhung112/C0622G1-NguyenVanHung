package ss4_access_modifier.bai_tap.Student;

public  class Student {
    private String name = "John";
    private String classes = "C02";

    public Student() {

    }

    public void setName(String name) {
        this.name = name;
    }

    void setClasses(String classes) {
        this.classes = classes;
    }

    public String display() {
        return this.name + " " + this.classes;
    }
}
