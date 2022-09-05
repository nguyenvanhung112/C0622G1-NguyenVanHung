package case_study.service.impl;

import case_study.model.Booking;
import case_study.model.person.Customer;
import case_study.service.IPromotionService;
import case_study.utils.ReadFileUlti;
import case_study.utils.WriteFileUlti;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class PromotionService implements IPromotionService {
    private static List<Customer> customerGetVoucher = new LinkedList<>();
    private static List<Customer> customersUseService = new LinkedList<>();
    private static Scanner scanner = new Scanner(System.in);
    CustomerService customerService = new CustomerService();
    BookingService bookingService = new BookingService();
    private static final String PROMOTION_LIST = "src\\case_study\\data\\promotion";

    @Override
    public void displayListCustomersGetVoucher() throws IOException, ParseException {

    }

    @Override
    public void displayListCustomersUseService() throws IOException, ParseException {
        customersUseService = this.getListCustomerBookingInYear();
        if (customersUseService.size() == 0){
            System.out.println("No customer booking in year!");
        }
        for (Customer customer : customersUseService) {
            System.out.println(customer);
        }
    }

    private List<Customer> getListCustomerBookingInYear() throws IOException, ParseException {
        System.out.println("Enter Year : ");
        List<Customer> customerList = new ArrayList<>();
        String year = scanner.nextLine();
        for (Customer customer : customerService.getListCustomer()) {
            for (Booking booking : bookingService.getListBooking()) {
                if (booking.getStartDay().toString().contains(year) && customer.getCustomerID().equals(booking.getCustomerID())) {
                    if (customerList.contains(customer)) {
                        continue;
                    }
                    customerList.add(customer);
                }
            }
        }
        return customerList;
    }

    public static List<Customer> readCustomerFile(String path) throws IOException {
        List<String> strings = ReadFileUlti.readFile(path);
        List<Customer> customers = new ArrayList<>();
        String[] info;
        for (String line : strings) {
            info = line.split(",");
            customers.add(new Customer(info[0], info[1], info[2], (info[3]), (info[4]), info[5], info[6], info[7], info[8]));
        }
        return customers;
    }

    public static void writeCustomerFile(String path, List<Customer> customers) throws IOException {
        StringBuilder data = new StringBuilder();
        for (Customer customer : customers) {
            data.append(customer.toString());
            data.append("\n");
        }
        WriteFileUlti.writeFile(path, data.toString());
    }
}