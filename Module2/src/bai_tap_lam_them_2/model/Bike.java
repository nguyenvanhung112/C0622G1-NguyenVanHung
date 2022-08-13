package bai_tap_lam_them_2.model;

public class Bike extends Vehicle {
    private String wattage;

    public Bike() {
    }

    public Bike(String wattage) {
        this.wattage = wattage;
    }

    public Bike(String licensePlates, Product company, String manufacture, String owner, String wattage) {
        super(licensePlates, company, manufacture, owner);
        this.wattage = wattage;
    }

    public String getWattage() {
        return wattage;
    }

    public void setWattage(String wattage) {
        this.wattage = wattage;
    }

    @Override
    public String toString() {
        return "Bike{" +
                "licensePlates='" + getLicensePlates() + '\'' +
                ", company='" + getCompany() + '\'' +
                ", manufacture='" + getManufacture() + '\'' +
                ", owner='" + getOwner() + '\'' +
                "wattage='" + wattage + '\'' +
                '}';
    }
}
