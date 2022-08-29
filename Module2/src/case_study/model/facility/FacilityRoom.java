package case_study.model.facility;

public class FacilityRoom extends Facility {
    private String freeService;

    public FacilityRoom(String freeService) {
        this.freeService = freeService;
    }


    public FacilityRoom(String serviceID, String serviceName, double usingArea, double price, int maximumPeople, String rentalType, String freeService) {
        super(serviceID, serviceName, usingArea, price, maximumPeople, rentalType);
        this.freeService = freeService;
    }

    public FacilityRoom() {
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s,%s,%s",this.getServiceID(),this.getServiceName(),this.getUsingArea(),this.getPrice(),this.getMaximumPeople(),this.getRentalType(),this.getFreeService());

    }
}
