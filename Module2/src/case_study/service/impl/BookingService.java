package case_study.service.impl;

import case_study.model.Booking;
import case_study.model.facility.Facility;
import case_study.model.person.Customer;
import case_study.service.IBookingService;
import case_study.service.impl.Facility.FacilityService;
import case_study.utils.ReadFileUlti;
import case_study.utils.SortByStartDateThenEndDate;
import case_study.utils.WriteFileUlti;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;


public class BookingService implements IBookingService {
    public static Set<Booking> bookings = new TreeSet<>(new SortByStartDateThenEndDate());
    private static Scanner scanner = new Scanner(System.in);
    private final String FACILITY_LIST = "src\\case_study\\data\\facility";
    private final String BOOKING_LIST = "src\\case_study\\data\\booking";
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private CustomerService customerService = new CustomerService();
    private FacilityService facilityService = new FacilityService();

    @Override
    public void addNewBooking() throws IOException, ParseException {
        bookings = readBookingFile(BOOKING_LIST);
        customerService.displayListCustomers();
        String customerID;
        Customer customer;
        while (true) {
            System.out.println("Enter Customer ID:");
            customerID = scanner.nextLine();
            customer = customerService.findCustomerByID(customerID);
            if (customer == null) {
                System.out.println("Not found");
            } else {
                break;
            }

        }
        facilityService.displayListFacilitys();
        String serviceID;
        Facility facility;
        while (true) {
            System.out.println("Enter Service ID:");
            serviceID = scanner.nextLine();
            facility = facilityService.findServiceByID(serviceID);
            if (facility == null) {
                System.out.println("Not found");
            } else {
                break;
            }
        }

        String bookingID = "BK-" + this.creatNewID();

        Date startDay;
        Date date = new Date();
        while (true) {
            try {
                System.out.println("Enter Start day: ");
                String startDayCheck = scanner.nextLine();
                if (!startDayCheck.matches("^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|" +
                        "(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))" +
                        "(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)" +
                        "?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|" +
                        "^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$")) {
                    throw new Exception("Date is not format!");
                }
                startDay = dateFormat.parse(startDayCheck);
                if (startDay.compareTo(date) < 0) {
                    throw new Exception("The start date you entered occurs before the date now!");
                }
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        Date endDay;
        while (true) {
            try {
                System.out.println("Enter End day: ");
                String endDayCheck = scanner.nextLine();
                if (!endDayCheck.matches("^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|" +
                        "(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))" +
                        "(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)" +
                        "?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|" +
                        "^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$")) {
                    throw new Exception("Data is not format!");
                }
                endDay = dateFormat.parse(endDayCheck);
                if (endDay.compareTo(startDay) < 0) {
                    throw new Exception("The end date you entered occurs before the start date!");
                }
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        // Tính số ngày thuê:
//        long dates = endDay.getTime() - startDay.getTime();
//        long c = dates*50000;
//        System.out.println(TimeUnit.DAYS.convert(dates, TimeUnit.MILLISECONDS));
//        System.out.println(TimeUnit.DAYS.convert(c, TimeUnit.MILLISECONDS));
        Booking booking = new Booking(bookingID, startDay, endDay, customer.getCustomerID(), facility.getServiceID(), facility.getServiceName(), facility.getRentalType());
        bookings.add(booking);
        System.out.println("Add Booking success!");
        writeBookingFile(BOOKING_LIST, bookings);

        Integer value = FacilityService.facilities.get(facility);
        Integer newValue = value + 1;
        FacilityService.facilities.replace(facility, newValue);
        FacilityService.writeFacilityFile(FACILITY_LIST, FacilityService.facilities);
    }

    private int creatNewID() {
        return bookings.size() + 1;
    }

    @Override
    public void displayListBooking() throws IOException, ParseException {
        bookings = readBookingFile(BOOKING_LIST);
        if (bookings.size() == 0) {
            System.out.println("List is empty!");
        } else {
            System.out.println("List Booking: ");
            for (Booking booking : bookings) {
                System.out.println(booking);
            }
        }
    }

    public List<Booking> getListBooking() throws IOException, ParseException {
        bookings = readBookingFile(BOOKING_LIST);
        List<Booking> bookingsYear = new LinkedList<>();
        bookingsYear.addAll(bookings);
        return bookingsYear;
    }
    public static Set<Booking> readBookingFile(String path) throws IOException, ParseException {
        List<String> strings = ReadFileUlti.readFile(path);
        Set<Booking> bookings = new TreeSet<>(new SortByStartDateThenEndDate());
        String[] info;
        for (String line : strings) {
            info = line.split(",");
            bookings.add(new Booking(info[0], dateFormat.parse(info[1]), dateFormat.parse(info[2]), (info[3]), (info[4]), info[5], info[6]));
        }
        return bookings;
    }

    public static void writeBookingFile(String path, Set<Booking> bookings) throws IOException {
        StringBuilder data = new StringBuilder();
        for (Booking booking : bookings) {
            data.append(booking.toString());
            data.append("\n");
        }
        WriteFileUlti.writeFile(path, data.toString());
    }

    public Booking findBookingID() {
        System.out.println("Enter Booking ID: ");
        String bookingID = scanner.nextLine();
        for (Booking booking : bookings) {
            if (booking.getBookingID().equals(bookingID)) {
                return booking;
            }
        }
        return null;
    }
}