package case_study.model.facility;

public class FacilityHome extends Facility {
    private String freeService;

    public FacilityHome(String freeService) {
        this.freeService = freeService;
    }

    public FacilityHome(String serviceName, String usingArea, double price, int maximumPeople, String rentalType, String freeService) {
        super(serviceName, usingArea, price, maximumPeople, rentalType);
        this.freeService = freeService;
    }

    public FacilityHome() {
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

    @Override
    public String toString() {
        return "ServiceHome{" +
                "serviceName='" + getServiceName() + '\'' +
                ", usingArea='" + getUsingArea() + '\'' +
                ", price=" + getPrice() +
                ", maximumPeople=" + getMaximumPeople() +
                ", rentalType='" + getRentalType() + '\'' +
                "freeService='" + freeService + '\'' +
                '}';
    }
}
