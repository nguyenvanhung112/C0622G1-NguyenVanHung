package bai_thi_module_2.model;

import java.util.Date;

public class Employee extends Customer {
    private double wage;
    private String room;
    private String locus;

    public Employee() {
    }

    public Employee(double wage, String room, String locus) {
        this.wage = wage;
        this.room = room;
        this.locus = locus;
    }

    public Employee(String id, String name, Date dateOfbirth, String address, String phone, double wage, String room, String locus) {
        super(id, name, dateOfbirth, address, phone);
        this.wage = wage;
        this.room = room;
        this.locus = locus;
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getLocus() {
        return locus;
    }

    public void setLocus(String locus) {
        this.locus = locus;
    }

    @Override
    public String getInfo() {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s", this.getId(), this.getName(), dateFormat.format(this.getDateOfbirth()),
                this.getAddress(),this.getPhone(), this.getWage(), this.getRoom(),this.getLocus());
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s", this.getId(), this.getName(), dateFormat.format(this.getDateOfbirth()),
                this.getAddress(),this.getPhone(), this.getWage(), this.getRoom(),this.getLocus());
    }
}
