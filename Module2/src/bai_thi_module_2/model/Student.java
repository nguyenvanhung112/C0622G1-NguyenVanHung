package bai_thi_module_2.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Student extends Customer{
    private double match;
    private String study;
    private Date inDay;
    static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    public double getMatch() {
        return match;
    }

    public void setMatch(double match) {
        this.match = match;
    }

    public String getStudy() {
        return study;
    }

    public void setStudy(String study) {
        this.study = study;
    }

    public Date getInDay() {
        return inDay;
    }

    public void setInDay(Date inDay) {
        this.inDay = inDay;
    }

    public Student(double match, String study, Date inDay) {
        this.match = match;
        this.study = study;
        this.inDay = inDay;
    }

    public Student(String id, String name, Date dateOfbirth, String address, String phone, double match, String study, Date inDay) {
        super(id, name, dateOfbirth, address, phone);
        this.match = match;
        this.study = study;
        this.inDay = inDay;
    }

    public Student() {
    }

    @Override
    public String getInfo() {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s", this.getId(), this.getName(), dateFormat.format(this.getDateOfbirth()),
                this.getAddress(),this.getPhone(), this.getMatch(), this.getStudy(),dateFormat.format(this.getInDay()));
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s", this.getId(), this.getName(), dateFormat.format(this.getDateOfbirth()),
                this.getAddress(),this.getPhone(), this.getMatch(), this.getStudy(),dateFormat.format(this.getInDay()));
    }
}
