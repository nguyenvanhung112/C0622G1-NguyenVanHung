package case_study.model.facility;

public abstract class Facility {
    private String serviceName;
    private String usingArea;
    private double price;
    private int maximumPeople;
    private String rentalType;

    public Facility() {
    }

    public Facility(String serviceName, String usingArea, double price, int maximumPeople, String rentalType) {
        this.serviceName = serviceName;
        this.usingArea = usingArea;
        this.price = price;
        this.maximumPeople = maximumPeople;
        this.rentalType = rentalType;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getUsingArea() {
        return usingArea;
    }

    public void setUsingArea(String usingArea) {
        this.usingArea = usingArea;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getMaximumPeople() {
        return maximumPeople;
    }

    public void setMaximumPeople(int maximumPeople) {
        this.maximumPeople = maximumPeople;
    }

    public String getRentalType() {
        return rentalType;
    }

    public void setRentalType(String rentalType) {
        this.rentalType = rentalType;
    }

    @Override
    public String toString() {
        return "Service{" +
                "serviceName='" + serviceName + '\'' +
                ", usingArea='" + usingArea + '\'' +
                ", price=" + price +
                ", maximumPeople=" + maximumPeople +
                ", rentalType='" + rentalType + '\'' +
                '}';
    }
}
