package case_study.service.impl;

import bai_tap_lam_them.model.Student;
import bai_tap_lam_them.ulti.ReadFileUlti;
import case_study.model.person.Employee;
import case_study.service.IEmployeeService;
import ulti_exception.DateOfBirthException;
import ulti_exception.GenderException;
import ulti_exception.StringFormatException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static bai_tap_lam_them.ulti.WriteFileUlti.writeFile;

public class EmployeeService implements IEmployeeService {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Employee> employees = new ArrayList<>();
    final String PATH_LIST_EMPLOYEES = "src\\case_study\\data\\employees";

    @Override
    public void displayListEmployees() throws IOException {
        employees = readEmployeeFile(PATH_LIST_EMPLOYEES);
        for (Employee employee : employees) {
            System.out.println(employee);
        }
        writeEmployeeFile(PATH_LIST_EMPLOYEES, employees);
    }

    @Override
    public void addNewEmployee() throws IOException {
        employees = readEmployeeFile(PATH_LIST_EMPLOYEES);
        Employee employee = this.infoEmployee();
        employees.add(employee);
        System.out.println("Added new success");
        writeEmployeeFile(PATH_LIST_EMPLOYEES, employees);
    }

    private Employee infoEmployee() throws IOException {
        System.out.println("Input name");
        String name = scanner.nextLine();
        System.out.println("Input date of birth");
        String dateOfBirth = scanner.nextLine();
        System.out.println("Input gender");
        String gender = scanner.nextLine();
        System.out.println("Input ID card");
        String idCard = scanner.nextLine();
        System.out.println("Input phone");
        String phone = scanner.nextLine();
        System.out.println("Input Email");
        String email = scanner.nextLine();
        System.out.println("Input Employee code");
        String employeeCode = scanner.nextLine();
        System.out.println("Input Level\n" + "\nTrung cấp" + "\nCao đẳng" + "\nĐại học" + "\nSau đại học" + "\nChọn trình độ:\n");
        String level = scanner.nextLine();
        System.out.println("Input Locus\n" + "\nLễ tân" + "\nPhục vụ" + "\nChuyên viên" +
                "\nGiám sát" + "\nQuản lí" + "\nGiám đốc" + "\nChọn vị trí:\n");
        String locus = scanner.nextLine();
        System.out.println("Input Wage");
        double wage = Double.parseDouble(scanner.nextLine());
        return new Employee(name, dateOfBirth, gender, idCard, phone, email, employeeCode, level, locus, wage);
    }

    @Override
    public void editEmployee() throws IOException {
        employees = readEmployeeFile(PATH_LIST_EMPLOYEES);
        Employee employee = this.findEmployee();
        if (employee == null) {
            System.out.println("Not found");
        } else {
            int index = employees.indexOf(employee);
            employees.set(index, infoEmployee());
            System.out.println("Edit success");
        }
        writeEmployeeFile(PATH_LIST_EMPLOYEES, employees);
    }

    private Employee findEmployee() throws IOException {
        employees = readEmployeeFile(PATH_LIST_EMPLOYEES);
        System.out.println("Enter the name you want to search");
        String name = scanner.nextLine();
        for (Employee employee : employees) {
            if (employee.getName().equals(name)) {
                return employee;
            }
        }
        return null;
    }

    public static List<Employee> readEmployeeFile(String path) throws IOException {
        List<String> strings = ReadFileUlti.readFile(path);
        List<Employee> employees = new ArrayList<>();

        String[] info;
        for (String line : strings) {
            info = line.split(",");
            if (info.length == 10) {
                employees.add(new Employee(info[0], info[1], info[2], info[3], info[4], info[5], info[6], info[7], info[8], Double.parseDouble(info[9])));
            }
        }
        return employees;
    }

    public static void writeEmployeeFile(String path, List<Employee> employees) throws IOException {
        String data = "";
        for (Employee employee : employees) {
            data += employee.toString();
            data += "\n";
        }
        writeFile(path, data);
    }
}
