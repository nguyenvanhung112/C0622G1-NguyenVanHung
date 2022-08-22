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

    public FacilityHouse(String serviceName, String usingArea, double price, int maximumPeople, String rentalType, String roomStandard, int numberFloors) {
        super(serviceName, usingArea, price, maximumPeople, rentalType);
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
        return "ServiceHouse{" +
                "serviceName='" + getServiceName() + '\'' +
                ", usingArea='" + getUsingArea() + '\'' +
                ", price=" + getPrice() +
                ", maximumPeople=" + getMaximumPeople() +
                ", rentalType='" + getRentalType() + '\'' +
                "roomStandard='" + roomStandard + '\'' +
                ", numberFloors=" + numberFloors +
                '}';
    }
}
