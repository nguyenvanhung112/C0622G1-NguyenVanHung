package bai_tap_lam_them_2.model;

public class Car extends Vehicle {
    private int seats;
    private String model;

    public Car() {
    }

    public Car(int seats, String model) {
        this.seats = seats;
        this.model = model;
    }

    public Car(String licensePlates, Product company, String manufacture, String owner, int seats, String model) {
        super(licensePlates, company, manufacture, owner);
        this.seats = seats;
        this.model = model;
    }


    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Car{" +
                "licensePlates='" + getLicensePlates() + '\'' +
                ", company='" + getCompany() + '\'' +
                ", manufacture='" + getManufacture() + '\'' +
                ", owner='" + getOwner() + '\'' +
                "seats=" + seats +
                ", model='" + model + '\'' +
                '}';
    }
}
