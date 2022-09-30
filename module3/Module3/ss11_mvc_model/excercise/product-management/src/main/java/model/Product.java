package model;

public class Product {
    private int id;
    private String name;
    private String attribute;
    private double price;

    public Product() {
    }

    public Product(int id, String name, String attribute, double price) {
        this.id = id;
        this.name = name;
        this.attribute = attribute;
        this.price = price;
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

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
