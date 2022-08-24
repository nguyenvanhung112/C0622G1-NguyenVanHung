package case_study.model.person;

public class Employee extends Person {
    private String employeeCode;
    private String level;
    private String locus;
    private double wage;

    public Employee() {
    }

    public Employee(String employeeCode, String level, double wage) {
        this.employeeCode = employeeCode;
        this.level = level;
        this.wage = wage;
    }

    public Employee(String name, String dateOfBirth, String gender, String idCard, String phone, String email, String employeeCode, String level,String locus, double wage) {
        super(name, dateOfBirth, gender, idCard, phone, email);
        this.locus = locus;
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

    public String getLocus() {
        return locus;
    }

    public void setLocus(String locus) {
        this.locus = locus;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s",this.getName(),this.getDateOfBirth(),this.getGender(),this.getIdCard(),
                this.getPhone(),this.getEmail(),this.getEmployeeCode(),this.getLevel(),this.getLocus(),this.getWage());
//                "Employee{" +
//                "name='" + getName() + '\'' +
//                ", dateOfBirth='" + getDateOfBirth() + '\'' +
//                ", gender='" + getGender() + '\'' +
//                ", idCard='" + getIdCard() + '\'' +
//                ", phone='" + getPhone() + '\'' +
//                ", email='" + getEmail() + '\'' +
//                "employeeCode='" + employeeCode + '\'' +
//                ", level='" + level + '\'' +
//                ", wage=" + wage +
//                '}';
    }
}
