package bai_tap_lam_them_2.model;

public class Truck extends Vehicle {
    private int tonnage;

    public Truck() {
    }

    public Truck(int tonnage) {
        this.tonnage = tonnage;
    }

    public Truck(String licensePlates, Product company, String manufacture, String owner, int tonnage) {
        super(licensePlates, company, manufacture, owner);
        this.tonnage = tonnage;
    }

    public double getTonnage() {
        return tonnage;
    }

    public void setTonnage(int tonnage) {
        this.tonnage = tonnage;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "licensePlates='" + getLicensePlates() + '\'' +
                ", company='" + getCompany() + '\'' +
                ", manufacture='" + getManufacture() + '\'' +
                ", owner='" + getOwner() + '\'' +
                "tonnage=" + tonnage +
                '}';
    }
}
