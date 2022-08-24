package case_study.model;

public class Booking {
    String codeBooking;
    String startDay;
    String endDay;
    String customerCode;
    String nameService;
    String typeService;

    public Booking() {
    }

    public Booking(String codeBooking, String startDay, String endDay, String customerCode, String nameService, String typeService) {
        this.codeBooking = codeBooking;
        this.startDay = startDay;
        this.endDay = endDay;
        this.customerCode = customerCode;
        this.nameService = nameService;
        this.typeService = typeService;
    }

    public String getCodeBooking() {
        return codeBooking;
    }

    public void setCodeBooking(String codeBooking) {
        this.codeBooking = codeBooking;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getEndDay() {
        return endDay;
    }

    public void setEndDay(String endDay) {
        this.endDay = endDay;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public String getTypeService() {
        return typeService;
    }

    public void setTypeService(String typeService) {
        this.typeService = typeService;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s,%s", this.getCodeBooking(), this.getStartDay(), this.getEndDay(),
                this.getCustomerCode(), this.getNameService(), this.getTypeService());
//                "Booking{" +
//                "codeBooking='" + codeBooking + '\'' +
//                ", startDay='" + startDay + '\'' +
//                ", endDay='" + endDay + '\'' +
//                ", customerCode='" + customerCode + '\'' +
//                ", nameService='" + nameService + '\'' +
//                ", typeService='" + typeService + '\'' +
//                '}';
    }
}
