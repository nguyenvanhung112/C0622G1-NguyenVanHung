package case_study.model;

import case_study.model.facility.Facility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Booking {
    static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private String bookingID;
    private Date startDay;
    private Date endDay;
    private String customerID;
    private String serviceID;
    private String serviceName;
    private String serviceType;


    public Booking() {
    }

    public Booking(String bookingID, Date startDay, Date endDay, String customerID, String serviceID, String serviceName, String serviceType) {
        this.bookingID = bookingID;
        this.startDay = startDay;
        this.endDay = endDay;
        this.customerID = customerID;
        this.serviceID = serviceID;
        this.serviceName = serviceName;
        this.serviceType = serviceType;
    }

    public Booking(String bookingID, Date startDay, Date endDay, String customerID, String serviceName, String serviceType) {
        this.bookingID = bookingID;
        this.startDay = startDay;
        this.endDay = endDay;
        this.customerID = customerID;
        this.serviceName = serviceName;
        this.serviceType = serviceType;
    }
    public String getServiceID() {
        return serviceID;
    }

    public void setServiceID(String serviceID) {
        this.serviceID = serviceID;
    }
    public String getBookingID() {
        return bookingID;
    }

    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }

    public Date getStartDay() {
        return startDay;
    }

    public void setStartDay(Date startDay) {
        this.startDay = startDay;
    }

    public Date getEndDay() {
        return endDay;
    }

    public void setEndDay(Date endDay) {
        this.endDay = endDay;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s,%s,%s", this.getBookingID(), dateFormat.format(this.getStartDay()), dateFormat.format(this.getEndDay()),
                this.getCustomerID(),this.getServiceID(), this.getServiceName(), this.getServiceType());

    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return Objects.equals(getServiceID(), booking.getServiceID());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getServiceID());
    }
}
