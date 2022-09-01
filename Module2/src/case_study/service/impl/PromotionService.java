package case_study.service.impl;

import case_study.model.Booking;
import case_study.model.person.Customer;
import case_study.service.IPromotionService;
import case_study.utils.ReadFileUlti;
import case_study.utils.SortByStartDateThenEndDate;
import case_study.utils.WriteFileUlti;

import java.io.IOException;
import java.text.ParseException;
import java.util.*;

public class PromotionService implements IPromotionService {
    private static List<Customer> customerGetVoucher = new LinkedList<>();
    private static List<Customer> customersUseService = new LinkedList<>();
    CustomerService customerService = new CustomerService();
    BookingService bookingService = new BookingService();
    private static final String PROMOTION_LIST = "src\\case_study\\data\\promotion";

    @Override
    public void displayListCustomersGetVoucher() throws IOException, ParseException {
        for (Customer customer : customerService.getListCustomer()) {
            for (String string : bookingService.getListBookingYear()) {
                if (string.contains(customer.getCustomerID())) {
                    if (customerGetVoucher.contains(customer)) {
                        continue;
                    }
                    customerGetVoucher.add(customer);
                }
            }
        }
        for (Customer item : customerGetVoucher) {
            System.out.println(item);
        }
    }

    @Override
    public void displayListCustomersUseService() throws IOException, ParseException {
        customersUseService = readCustomerFile(PROMOTION_LIST);
        for (Customer customer : customerService.getListCustomer()) {
            if (bookingService.getListBookingCustomerID().contains(customer.getCustomerID())) {
                if (customersUseService.contains(customer)) {
                    continue;
                }
                customersUseService.add(customer);
            }
        }
        for (Customer item : customersUseService) {
            System.out.println(item);
        }
        writeCustomerFile(PROMOTION_LIST, customersUseService);
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
        String data = "";
        for (Customer customer : customers) {
            data += customer.toString();
            data += "\n";
        }
        WriteFileUlti.writeFile(path, data);
    }
}