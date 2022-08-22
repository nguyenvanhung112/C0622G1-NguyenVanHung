package case_study.model.facility;

public class FacilityVilla extends Facility {
    private String roomStandard;
    private float poolArea;
    private int numberFloors;

    public FacilityVilla() {
    }

    public FacilityVilla(String roomStandard, float poolArea, int numberFloors) {
        this.roomStandard = roomStandard;
        this.poolArea = poolArea;
        this.numberFloors = numberFloors;
    }

    public FacilityVilla(String serviceName, String usingArea, double price, int maximumPeople, String rentalType, String roomStandard, float poolArea, int numberFloors) {
        super(serviceName, usingArea, price, maximumPeople, rentalType);
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

    public float getPoolArea() {
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
        return "ServiceVilla{" +
                "serviceName='" + getServiceName() + '\'' +
                ", usingArea='" + getUsingArea() + '\'' +
                ", price=" + getPrice() +
                ", maximumPeople=" + getMaximumPeople() +
                ", rentalType='" + getRentalType() + '\'' +
                "roomStandard='" + roomStandard + '\'' +
                ", poolArea=" + poolArea +
                ", numberFloors=" + numberFloors +
                '}';
    }
}
