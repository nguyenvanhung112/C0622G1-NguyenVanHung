package case_study.model.facility;

public class FacilityHouse extends Facility {
    private String roomStandard;
    private int numberFloors;

    public FacilityHouse() {
    }

    public FacilityHouse(String roomStandard, int numberFloors) {
        this.roomStandard = roomStandard;
        this.numberFloors = numberFloors;
    }

    public FacilityHouse(String serviceID, String serviceName, double usingArea, double price, int maximumPeople, String rentalType, String roomStandard, int numberFloors) {
        super(serviceID, serviceName, usingArea, price, maximumPeople, rentalType);
        this.roomStandard = roomStandard;
        this.numberFloors = numberFloors;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public int getNumberFloors() {
        return numberFloors;
    }

    public void setNumberFloors(int numberFloors) {
        this.numberFloors = numberFloors;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s",this.getServiceID(),this.getServiceName(),this.getUsingArea(),this.getPrice(),
                this.getMaximumPeople(),this.getRentalType(),this.getRoomStandard(),this.getNumberFloors());
    }
}
