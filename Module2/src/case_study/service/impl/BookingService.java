package case_study.service.impl;

import case_study.model.Booking;
import case_study.model.facility.Facility;
import case_study.model.person.Customer;
import case_study.service.IBookingService;
import case_study.service.impl.Facility.FacilityService;
import case_study.utils.DateOfBirthException;

import java.io.IOException;
import java.util.*;



public class BookingService implements IBookingService {
    private static Queue<Booking> bookings = new LinkedList<>();
    private static Scanner scanner = new Scanner(System.in);

    @Override
    public void addNewBooking() throws IOException {
        System.out.println("List customer:");
        CustomerService customerService = new CustomerService();
        customerService.displayListCustomers();
        System.out.println("Enter Customer ID:");
        String customerID = scanner.nextLine();
        Customer customer = customerService.findCustomerByID(customerID);

        System.out.println("List service:");
        FacilityService facilityService = new FacilityService();
        facilityService.displayListFacilitys();
        System.out.println("Enter Facility Service:");
        String serviceID = scanner.nextLine();
        Facility facility = facilityService.findServiceByID(serviceID);

        int bookingID = this.creatNewID();

        String starDay;
        while (true) {
            try {
                System.out.println("Enter Start day: ");
                starDay = scanner.nextLine();
                if (!starDay.matches("^\\d+\\d+\\W+\\d+\\d+\\W+\\d+\\d+\\d+\\d$")) {
                    throw new Exception("End day is not format, again: ");
                }
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        String endDay;
        while (true) {
            try {
                System.out.println("Enter End day: ");
                endDay = scanner.nextLine();
                if (!endDay.matches("^\\d+\\d+\\W+\\d+\\d+\\W+\\d+\\d+\\d+\\d$")) {
                    throw new Exception("End day is not format, again: ");
                }
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        Booking booking = new Booking(bookingID, starDay, endDay, customer.getCustomerID(), facility.getServiceName(), facility.getRentalType());
        bookings.add(booking);
        System.out.println("Add Booking success!");

        Integer value = FacilityService.facilities.get(facility);
        Integer newValue = value + 1;
        FacilityService.facilities.replace(facility, newValue);
    }

    private int creatNewID() {
        return bookings.size() + 1;
    }

    @Override
    public void displayListBooking() {
        for (Booking booking : bookings) {
            System.out.println(booking);
        }
    }
}
