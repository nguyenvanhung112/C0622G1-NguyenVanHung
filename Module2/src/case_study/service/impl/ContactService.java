package case_study.service.impl;

import case_study.model.Booking;
import case_study.model.Contract;
import case_study.model.person.Customer;
import case_study.service.IContactService;
import case_study.utils.ReadFileUlti;
import case_study.utils.WriteFileUlti;

import java.io.IOException;
import java.text.ParseException;
import java.util.*;

public class ContactService implements IContactService {
    static Scanner scanner = new Scanner(System.in);
    private static List<Contract> contracts = new ArrayList<>();
    BookingService bookingService = new BookingService();
    CustomerService customerService = new CustomerService();
    private static final String CONTRACT_LIST = "src\\case_study\\data\\contact";

    @Override
    public void creatNewContracts() throws IOException, ParseException {
        contracts = readContractFile(CONTRACT_LIST);
        Contract contract = this.infoContract();
        contracts.add(contract);
        System.out.println("Add Success!");
        writeContractFile(CONTRACT_LIST, contracts);
    }

    private Contract infoContract() throws IOException, ParseException {
        String contractID;
        while (true) {
            try {
                System.out.println("Enter Contract ID: ");
                contractID = scanner.nextLine();
                if (!contractID.matches("[0-9]{4}")) {
                    throw new Exception("Contract is not format!");
                }
                for (Contract contract : contracts) {
                    if (contract.getContractID().contains(contractID)) {
                        throw new Exception("ID is duplicated!, again:");
                    }
                }
                contractID = "CT-" + contractID;
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        Booking booking;
        bookingService.displayListBooking();
        while (true) {
            boolean check = true;
            booking = bookingService.findBookingID();
            if (booking == null) {
                System.out.println("Not found!");
                check = false;
            }
            if (check) break;
        }
        double moneyFirst;
        while (true) {
            try {
                System.out.println("Enter Money first: ");
                moneyFirst = Double.parseDouble(scanner.nextLine());
                if (moneyFirst < 0) {
                    throw new Exception("The Money first must be more than 0, again: ");
                }
                if (Double.isNaN(moneyFirst)) {
                    throw new NumberFormatException("The data you enter is not a number!");
                }
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        double totalMoney;
        while (true) {
            try {
                System.out.println("Enter Money Total: ");
                totalMoney = Double.parseDouble(scanner.nextLine());
                if (totalMoney < 0) {
                    throw new Exception("The Money total must be more than 0, again: ");
                }
                if (Double.isNaN(totalMoney)) {
                    throw new NumberFormatException("The data you enter is not a number!");
                }
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        Customer customer;
        customerService.displayListCustomers();
        while (true) {
            boolean check = true;
            System.out.println("Enter Customer ID: ");
            String customerID = scanner.nextLine();
            customer = customerService.findCustomerByID(customerID);
            if (customer == null) {
                System.out.println("Not found!");
                check = false;
            }
            if (check) break;
        }
        return new Contract(contractID, booking.getBookingID(), moneyFirst, totalMoney, customer.getCustomerID());
    }


    @Override
    public void displayListContracts() throws IOException, ParseException {
        contracts = readContractFile(CONTRACT_LIST);
        if (contracts.size() == 0) {
            System.out.println("List is empty!");
        } else {
            System.out.println("List Contract: ");
            for (Contract contract : contracts) {
                System.out.println(contract);
            }
        }
    }

    @Override
    public void editContracts() throws IOException, ParseException {
        displayListContracts();
        Contract contract = this.findContractByID();
        if (contract == null) {
            System.out.println("Not found!");
        } else {
            while (true) {
                System.out.println("Edit Contract :\n" +
                        "1.\tEdit Contract ID\n" +
                        "2.\tEdit Money First\n" +
                        "3.\tEdit Money Total\n");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        System.out.println("Enter Contrart ID: ");
                        String contractID = scanner.nextLine();
                        contractID = "CT-" + contractID;
                        contract.setContractID(contractID);
                        break;
                    case 2:
                        System.out.println("Enter Money First: ");
                        double moneyFirst = Double.parseDouble(scanner.nextLine());
                        contract.setMoneyFirst(moneyFirst);
                        break;
                    case 3:
                        System.out.println("Enter Money Total: ");
                        double moneyTotal = Double.parseDouble(scanner.nextLine());
                        contract.setTotalMoney(moneyTotal);
                        break;
                    default:
                        System.out.println("Enter the correct function");
                }
                System.out.println("Edited success!");
                System.out.println(contract);
                writeContractFile(CONTRACT_LIST, contracts);
                break;
            }
        }
    }

    private Contract findContractByID() throws IOException, ParseException {
        contracts = readContractFile(CONTRACT_LIST);
        System.out.println("Enter Contract ID: ");
        String contractID = scanner.nextLine();
        for (Contract contract : contracts) {
            if (contract.getContractID().equals(contractID)) {
                return contract;
            }
        }
        return null;
    }

    public static List<Contract> readContractFile(String path) throws IOException, ParseException {
        List<String> strings = ReadFileUlti.readFile(path);
        List<Contract> contracts = new ArrayList<>();
        String[] info;
        for (String line : strings) {
            info = line.split(",");
            contracts.add(new Contract(info[0], (info[1]), Double.parseDouble(info[2]), Double.parseDouble(info[3]), (info[4])));
        }
        return contracts;
    }

    public static void writeContractFile(String path, List<Contract> contracts) throws IOException {
        StringBuilder data = new StringBuilder();
        for (Contract contract : contracts) {
            data.append(contract.toString());
            data.append("\n");
        }
        WriteFileUlti.writeFile(path, data.toString());
    }
}
