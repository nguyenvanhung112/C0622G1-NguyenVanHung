package case_study.model.facility;

import java.util.Objects;

public abstract class Facility {
    private String serviceID;
    private String serviceName;
    private double usingArea;
    private double price;
    private int maximumPeople;
    private String rentalType;

    public Facility() {
    }

    public Facility(String serviceID, String serviceName, double usingArea, double price, int maximumPeople, String rentalType) {
        this.serviceID = serviceID;
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

    public double getUsingArea() {
        return usingArea;
    }

    public void setUsingArea(double usingArea) {
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

    public String getServiceID() {
        return serviceID;
    }

    public void setServiceID(String serviceID) {
        this.serviceID = serviceID;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s,%s", this.getServiceID(), this.getServiceName(), this.getUsingArea(), this.getPrice(),
                this.getMaximumPeople(), this.getRentalType());
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Facility facility = (Facility) o;
        return Objects.equals(serviceID, facility.serviceID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serviceID);
    }
}
