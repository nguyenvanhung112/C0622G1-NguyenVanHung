package case_study.model.person;

public class Employee extends Person {
    private String employeeID;
    private String level;
    private String locus;
    private double wage;

    public Employee() {
    }

    public Employee(String employeeID, String level, double wage) {
        this.employeeID = employeeID;
        this.level = level;
        this.wage = wage;
    }

    public Employee(String name, String dateOfBirth, String gender, String idCard, String phone, String email, String employeeID, String level, String locus, double wage) {
        super(name, dateOfBirth, gender, idCard, phone, email);
        this.locus = locus;
        this.employeeID = employeeID;
        this.level = level;
        this.wage = wage;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
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
                this.getPhone(),this.getEmail(),this.getEmployeeID(),this.getLevel(),this.getLocus(),this.getWage());
    }
}
