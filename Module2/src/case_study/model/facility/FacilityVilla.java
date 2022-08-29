package case_study.model.facility;

public class FacilityVilla extends Facility {
    private String roomStandard;
    private double poolArea;
    private int numberFloors;

    public FacilityVilla() {
    }

    public FacilityVilla(String roomStandard, float poolArea, int numberFloors) {
        this.roomStandard = roomStandard;
        this.poolArea = poolArea;
        this.numberFloors = numberFloors;
    }

    public FacilityVilla(String serviceID, String serviceName, double usingArea, double price, int maximumPeople, String rentalType, String roomStandard, double poolArea, int numberFloors) {
        super(serviceID, serviceName, usingArea, price, maximumPeople, rentalType);
        this.roomStandard = roomStandard;
        this.poolArea = poolArea;
        this.numberFloors = numberFloors;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(float poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumberFloors() {
        return numberFloors;
    }

    public void setNumberFloors(int numberFloors) {
        this.numberFloors = numberFloors;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s",this.getServiceID(),this.getServiceName(),this.getUsingArea(),
                this.getPrice(),this.getMaximumPeople(),this.getRentalType(),this.getRoomStandard(),this.getPoolArea(),this.getNumberFloors());
    }
}
