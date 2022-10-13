package bai_thi_module_2.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Customer {
    private String id;
    private String name;
    private Date dateOfbirth;
    private String address;
    private String phone;
    static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    public Customer() {
    }

    public Customer(String id, String name, Date dateOfbirth, String address, String phone) {
        this.id = id;
        this.name = name;
        this.dateOfbirth = dateOfbirth;
        this.address = address;
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfbirth() {
        return dateOfbirth;
    }

    public void setDateOfbirth(Date dateOfbirth) {
        this.dateOfbirth = dateOfbirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public abstract String getInfo();

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", dateOfbirth=" + dateOfbirth +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
