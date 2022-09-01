package case_study.service.impl;

import case_study.model.person.Customer;
import case_study.service.ICustomerService;
import case_study.utils.*;
import ulti_exception.NameFormatException;

import java.io.IOException;
import java.util.*;

public class CustomerService implements ICustomerService {
    private static Scanner scanner = new Scanner(System.in);
    public static List<Customer> customers = new LinkedList<>();
    private static final String PATH_LIST_CUSTOMER = "src\\case_study\\data\\customers";


//    static {
//        try {
//            readCustomerFile(PATH_LIST_CUSTOMER);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        customers.add(new Customer("Nguyễn Mậu Hoàng", "12/02/2000", "Male", "206999123", "(84)-012345678", "mauhoang@gmail.com", "A9999", "Diamond", "Quảng Bình"));
//        customers.add(new Customer("Lê Anh Đạt", "12/07/2000", "Male", "206456789", "(84)-099999999", "anhdat@gmail.com", "A8888", "Diamond", "Đà Nẵng"));
//        try {
//            writeCustomerFile(PATH_LIST_CUSTOMER, customers);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }


    @Override
    public void displayListCustomers() throws IOException {
        customers = readCustomerFile(PATH_LIST_CUSTOMER);
        System.out.println("List customer: ");
        for (Customer item : customers) {
            System.out.println(item);
        }
    }

    @Override
    public void addNewCustomer() throws IOException {
        customers = readCustomerFile(PATH_LIST_CUSTOMER);
        Customer customer = this.infoCustomer();
        customers.add(customer);
        System.out.println("Add success");
        writeCustomerFile(PATH_LIST_CUSTOMER, customers);
    }
    public List<Customer> getListCustomer() throws IOException {
        customers = readCustomerFile(PATH_LIST_CUSTOMER);
        return customers;
    }

    private Customer infoCustomer() {
        String name;
        while (true) {
            try {
                System.out.println("Enter name: ");
                name = scanner.nextLine();
                if (!name.matches("\\D{5,50}")) {
                    throw new NameFormatException("Name is not format, again: ");
                } if (!name.matches("^\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*$")) {
                    throw new NameFormatException("Name is not format, again: ");
                }
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Enter Date of birth:");
        ValidateDateOfBirth.MyDate dateOfBirth = ValidateDateOfBirth.getDateInfo(18,100);
        dateOfBirth.getStrDate();
        String gender;
        while (true) {
            try {
                System.out.println("Enter gender: ");
                gender = scanner.nextLine();
                if (!gender.equals("Male") && (!gender.equals("Female"))) {
                    throw new GenderException("Gender is not format, again: ");
                }
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        String idCard;
        while (true) {
            try {
                System.out.println("Enter ID Card: ");
                idCard = scanner.nextLine();
                if (!idCard.matches("^[0-9]{9}$")) {
                    throw new Exception("ID card is not format, again: ");
                }
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        String phone;
        while (true) {
            try {
                System.out.println("Enter phone: ");
                phone = scanner.nextLine();
                if (!phone.matches("^[(][0-9]{2}[)][-][0][0-9]{8}$")) {
                    throw new Exception("Phone is not format, again: ");
                }
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        String email;
        while (true) {
            try {
                System.out.println("Enter email: ");
                email = scanner.nextLine();
                if (!email.matches("^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+([A-Za-z0-9]+\\.)+(com)$")) {
                    throw new Exception("Email is not format, again: ");
                }
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        String customerID;
        while (true) {
            try {
                System.out.println("Enter Customer ID: ");
                customerID = scanner.nextLine();
                if (!customerID.matches("[0-9]{4}")) {
                    throw new Exception("CustomerID is not format, again: ");
                }
                for (Customer customer: customers) {
                    if (customer.getCustomerID().contains(customerID)){
                        throw new Exception("ID is duplicated!, again: ");
                    }
                }
                customerID = "CS" + customerID;
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        String customerType = "";
        while (true) {
            try {
                boolean check = false;
                System.out.println("Enter select option: " +
                        "\n 1. Diamond" +
                        "\n 2. Platinum" +
                        "\n 3. Gold" +
                        "\n 4. Silver" +
                        "\n 5. Member");
                int choice1 = Integer.parseInt(scanner.nextLine());
                switch (choice1) {
                    case 1:
                        customerType = "Diamond";
                        check = true;
                        break;
                    case 2:
                        customerType = "Platinum";
                        check = true;
                        break;
                    case 3:
                        customerType = "Gold";
                        check = true;
                        break;
                    case 4:
                        customerType = "Silver";
                        check = true;
                        break;
                    case 5:
                        customerType = "Member";
                        check = true;
                        break;
                    default:
                        System.out.println("Your selection is not suitable, selection from 1 to 5");
                        check = false;
                }
                if (check) {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Input invalid");
            }
        }
        String address;
        while (true) {
            try {
                System.out.println("Enter address: ");
                address = scanner.nextLine();
                if (!address.matches("\\D{5,100}")) {
                    throw new Exception("Address is not format, again: ");
                } if (!address.matches("^\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*$")) {
                    throw new Exception("Address is not format, again: ");
                }
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return new Customer(name, dateOfBirth.getStrDate(), gender, idCard, phone, email, customerID, customerType, address);
    }

    private static String inputValidChoice() {
        while (true) {
            String choiceString = scanner.nextLine();
            if (choiceString.matches("^[0-9]+$")) {
                return choiceString;
            } else {
                System.out.print("You entered invalid! Again: ");
            }
        }
    }

    public static String inputValidChoiceEdit() {
        while (true) {
            String choiceString = scanner.nextLine();
            if (choiceString.matches("[1-2]")) {
                return choiceString;
            } else {
                System.out.print("You entered invalid! Again: ");
            }
        }
    }

    @Override
    public void editCustomer() throws IOException {
        customers = readCustomerFile(PATH_LIST_CUSTOMER);
        System.out.println("Enter Customer ID: ");
        String findCustomerByID = scanner.nextLine();
        Customer customer = this.findCustomerByID(findCustomerByID);
        if (customer == null) {
            System.out.println("Not found");
        } else {
            int index = customers.indexOf(customer);
            System.out.println("1. Edit all.");
            System.out.println("2. Edit each one.");
            int choiceEdit = Integer.parseInt(inputValidChoiceEdit());
            if (choiceEdit == 1) {
                customers.set(index, infoCustomer());
                System.out.println("Edited success");
                writeCustomerFile(PATH_LIST_CUSTOMER, customers);
            } else if (choiceEdit == 2) {
                while (true) {
                    System.out.println("" +
                            "1.\tEdit name\n" +
                            "2.\tEdit Date of birth\n" +
                            "3.\tEdit gender\n" +
                            "4.\tEdit ID Card\n" +
                            "5.\tEdit phone\n" +
                            "6.\tEdit Email\n" +
                            "7.\tEdit CustomerCode\n" +
                            "8.\tEdit TypeCustomer\n" +
                            "9.\tEdit Adress\n" +
                            "10.\tExit.\n" +
                            "\tEnter function\n");
                    int choice = Integer.parseInt(inputValidChoice());
                    switch (choice) {
                        case 1:
                            String name;
                            while (true) {
                                try {
                                    System.out.println("Enter name: ");
                                    name = scanner.nextLine();
                                    if (!name.matches("\\D{5,50}")) {
                                        throw new NameFormatException("Name is not format, again: ");
                                    }
                                    if (!name.matches("^\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*$")) {
                                        throw new NameFormatException("Name is not format, again: ");
                                    }
                                    customers.get(index).setName(name);
                                    break;
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                            }
                            break;
                        case 2:
                            System.out.println("Enter Date of birth:");
                            ValidateDateOfBirth.MyDate dateOfBirth = ValidateDateOfBirth.getDateInfo(18,100);
                            customers.get(index).setDateOfBirth(dateOfBirth.getStrDate());
                            break;
                        case 3:
                            String gender;
                            while (true) {
                                try {
                                    System.out.println("Enter gender: ");
                                    gender = scanner.nextLine();
                                    if (!gender.equals("Male") && (!gender.equals("Female"))) {
                                        throw new GenderException("Gender is not format, again: ");
                                    }
                                    customers.get(index).setGender(gender);
                                    break;
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                            }
                            break;
                        case 4:
                            String idCard;
                            while (true) {
                                try {
                                    System.out.println("Enter ID Card: ");
                                    idCard = scanner.nextLine();
                                    if (!idCard.matches("[0-9]{9}")) {
                                        throw new Exception("ID Card is not format, again: ");
                                    }
                                    customers.get(index).setIdCard(idCard);
                                    break;
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                            }
                            break;
                        case 5:
                            String phone;
                            while (true) {
                                try {
                                    System.out.println("Enter phone: ");
                                    phone = scanner.nextLine();
                                    if (!phone.matches("^[(][0-9]{2}[)][-][0][0-9]{8}$")) {
                                        throw new Exception("Phone is not format, again: ");
                                    }
                                    customers.get(index).setPhone(phone);
                                    break;
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                            }
                            break;
                        case 6:
                            String email;
                            while (true) {
                                try {
                                    System.out.println("Enter email: ");
                                    email = scanner.nextLine();
                                    if (!email.matches("^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+([A-Za-z0-9]+\\.)+(com)$")) {
                                        throw new Exception("Email is not format,  again: ");
                                    }
                                    customers.get(index).setEmail(email);
                                    break;
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                            }
                            break;
                        case 7:
                            String customerID;
                            while (true) {
                                try {
                                    System.out.println("Enter Customer ID: ");
                                    customerID = scanner.nextLine();
                                    for (Customer item : customers) {
                                        if (item.getCustomerID().contains(customerID)) {
                                            throw new Exception("ID is duplicated!, again: ");
                                        }
                                    }
                                    if (!customerID.matches("[0-9]{4}")) {
                                        throw new Exception("Customer Code is not format, again: ");
                                    }
                                    customerID = "CS" + customerID;
                                    customers.get(index).setCustomerID(customerID);
                                    break;
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                            }
                            break;
                        case 8:
                            String customerType = "";
                            while (true) {
                                try {
                                    boolean check = false;
                                    System.out.println("Enter select option: " +
                                            "\n 1. Diamond" +
                                            "\n 2. Platinum" +
                                            "\n 3. Gold" +
                                            "\n 4. Silver" +
                                            "\n 5. Member" +
                                            "\n 6. Exit");
                                    int choice1 = Integer.parseInt(scanner.nextLine());
                                    switch (choice1) {
                                        case 1:
                                            customerType = "Diamond";
                                            check = true;
                                            break;
                                        case 2:
                                            customerType = "Platinum";
                                            check = true;
                                            break;
                                        case 3:
                                            customerType = "Gold";
                                            check = true;
                                            break;
                                        case 4:
                                            customerType = "Silver";
                                            check = true;
                                            break;
                                        case 5:
                                            customerType = "Member";
                                            check = true;
                                            break;
                                        default:
                                            System.out.println("Your selection is not suitable, selection from 1 to 5");
                                            check = false;
                                    }
                                    if (check) {
                                        break;
                                    }
                                } catch (NumberFormatException e) {
                                    System.out.println("Input invalid");
                                }
                            }
                            customers.get(index).setCustomerType(customerType);
                            break;
                        case 9:
                            String address;
                            while (true) {
                                try {
                                    System.out.println("Enter Address: ");
                                    address = scanner.nextLine();
                                    if (!address.matches("\\D{5,100}")) {
                                        throw new Exception("Address is not format, again: ");
                                    }
                                    if (!address.matches("^\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*$")) {
                                        throw new Exception("Address is not format, again: ");
                                    }
                                    customers.get(index).setAddress(address);
                                    break;
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                            }
                            break;
                        case 10:
                            return;
                        default:
                            System.out.println("You entered invalid! ");
                            return;
                    }
                    System.out.println("Edited success");
                    writeCustomerFile(PATH_LIST_CUSTOMER, customers);
                    break;
                }
            }
        }
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

    public Customer findCustomerByID(String id) {
        for (Customer customer : customers) {
            if (customer.getCustomerID().equals(id)) {
                return customer;
            }
        }
        return null;
    }
}