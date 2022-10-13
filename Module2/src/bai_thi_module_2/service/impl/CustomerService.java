package bai_thi_module_2.service.impl;

import bai_thi_module_2.model.Customer;
import bai_thi_module_2.model.Employee;
import bai_thi_module_2.model.Student;
import bai_thi_module_2.service.ICustomerService;
import case_study.model.facility.Facility;
import case_study.model.facility.FacilityHouse;
import case_study.model.facility.FacilityRoom;
import case_study.model.facility.FacilityVilla;
import case_study.utils.ReadFileUlti;
import case_study.utils.WriteFileUlti;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class CustomerService implements ICustomerService {
    static List<Customer> customers = new LinkedList<>();
    EmployeeService employeeService = new EmployeeService();
    StudentService studentService = new StudentService();
    Scanner scanner = new Scanner(System.in);
    static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    static String PATH_CUSTOMER_LIST = "src\\bai_thi_module_2\\data\\customer";

    public void addCustomemrMenu() throws ParseException, IOException {
        while (true) {
            System.out.println("" +
                    "1.\tThêm mới nhân viên\n" +
                    "2.\tThêm mới học viên\n" +
                    "3.\tQuay lại" +
                    "\tEnter function\n");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    customers = readFileCustomer(PATH_CUSTOMER_LIST);
                    Employee employee = employeeService.addNewEmployee();
                    customers.add(employee);
                    System.out.println("Thêm mới thành công");
                    writeCustomerFile(PATH_CUSTOMER_LIST,customers);
                    break;
                case 2:
                    customers = readFileCustomer(PATH_CUSTOMER_LIST);
                    Student student = studentService.addNewStudent();
                    customers.add(student);
                    System.out.println("Thêm mới thành công");
                    writeCustomerFile(PATH_CUSTOMER_LIST,customers);
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Enter the correct function");
            }
        }
    }

    @Override
    public void deleteCustomer() throws IOException, ParseException {
        displayCustomer();
        while (true) {
            Customer customer = this.findByIdCustomer();
            if (customer == null) {
                System.out.println("Không tìm thấy");
            } else {
                System.out.println("Bạn có muốn xóa không");
                System.out.println("1. Đồng ý");
                System.out.println("2. Không");
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice == 1) {
                    customers.remove(customer);
                    System.out.println("Xóa thành công");
                    writeCustomerFile(PATH_CUSTOMER_LIST,customers);
                    break;
                }
            }
        }
    }

    private Customer findByIdCustomer() {
        System.out.println("Nhập vào ID muốn tìm");
        String id = scanner.nextLine();
        for (Customer customer : customers) {
            if (customer.getId().equals(id)) {
                return customer;
            }
        }
        return null;
    }

    @Override
    public void displayCustomer() throws IOException, ParseException {
        customers = readFileCustomer(PATH_CUSTOMER_LIST);
        sortByName();
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }
    private List<Customer> sortByName() throws IOException {
        Collections.sort(customers,new Comparator<Customer>() {
            @Override
            public int compare(Customer o1,Customer o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        return customers;
    }
    public static List<Customer> readFileCustomer(String path) throws IOException, ParseException {
        List<String> strings = ReadFileUlti.readFile(path);
        List<Customer> customers = new LinkedList<>();
        String[] info;
        for (String line : strings) {
            info = line.split(",");
            if (info[0].contains("NV")) {
                customers.add(new Employee(info[0], info[1], dateFormat.parse(info[2]), info[3], info[4], Double.parseDouble(info[5]), info[6], info[7]));
            } else if (info[0].contains("HV")) {
                customers.add(new Student(info[0], info[1], dateFormat.parse(info[2]), info[3], info[4], Double.parseDouble(info[5]), info[6],dateFormat.parse(info[7])));
            }
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
