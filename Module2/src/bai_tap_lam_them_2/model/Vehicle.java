package bai_tap_lam_them_2.model;

public class Vehicle {
    private String licensePlates;
    private Product company;
    private String manufacture;
    private String owner;

    public Vehicle() {
    }

    public Vehicle(String licensePlates, Product company, String manufacture, String owner) {
        this.licensePlates = licensePlates;
        this.company = company;
        this.manufacture = manufacture;
        this.owner = owner;
    }


    public String getLicensePlates() {
        return licensePlates;
    }

    public void setLicensePlates(String licensePlates) {
        this.licensePlates = licensePlates;
    }

    public Product getCompany() {
        return company;
    }

    public void setCompany(Product company) {
        this.company = company;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "licensePlates='" + licensePlates + '\'' +
                ", company='" + company + '\'' +
                ", manufacture='" + manufacture + '\'' +
                ", owner='" + owner + '\'' +
                '}';
    }
}
