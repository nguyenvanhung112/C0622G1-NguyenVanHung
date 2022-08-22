package case_study.model.person;

public class Employee extends Person {
    private String employeeCode;
    private String level;
    private double wage;

    public Employee() {
    }

    public Employee(String employeeCode, String level, double wage) {
        this.employeeCode = employeeCode;
        this.level = level;
        this.wage = wage;
    }

    public Employee(String name, String dateOfBirth, String gender, String idCard, String phone, String email, String employeeCode, String level, double wage) {
        super(name, dateOfBirth, gender, idCard, phone, email);
        this.employeeCode = employeeCode;
        this.level = level;
        this.wage = wage;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + getName() + '\'' +
                ", dateOfBirth='" + getDateOfBirth() + '\'' +
                ", gender='" + getGender() + '\'' +
                ", idCard='" + getIdCard() + '\'' +
                ", phone='" + getPhone() + '\'' +
                ", email='" + getEmail() + '\'' +
                "employeeCode='" + employeeCode + '\'' +
                ", level='" + level + '\'' +
                ", wage=" + wage +
                '}';
    }
}
