package product.model;

public class Product {
    private int id;
    private String name;
    private String attribute;
    private String company;

    public Product() {
    }

    public Product(int id, String name, String attribute, String company) {
        this.id = id;
        this.name = name;
        this.attribute = attribute;
        this.company = company;
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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
