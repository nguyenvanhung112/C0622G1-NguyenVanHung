package case_study.service.impl;

import case_study.model.person.Customer;
import case_study.model.person.Employee;
import case_study.service.IEmployeeService;
import case_study.utils.*;
import case_study.utils.DateOfBirthException;
import case_study.utils.GenderException;
import ulti_exception.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeService implements IEmployeeService {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Employee> employees = new ArrayList<>();
    private static final String PATH_LIST_EMPLOYEES = "src\\case_study\\data\\employees";

    @Override
    public void displayListEmployees() throws IOException {
        employees = readEmployeeFile(PATH_LIST_EMPLOYEES);
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    @Override
    public void addNewEmployee() throws IOException {
        employees = readEmployeeFile(PATH_LIST_EMPLOYEES);
        Employee employee = this.infoEmployee();
        employees.add(employee);
        System.out.println("Add success");
        writeEmployeeFile(PATH_LIST_EMPLOYEES, employees);
    }

    private Employee infoEmployee() throws IOException {
        String name;
        while (true) {
            try {
                System.out.println("Enter name: ");
                name = scanner.nextLine();
                String str;
                if (!name.matches("\\D{5,50}")) {
                    throw new NameFormatException("Name is not format, again: ");
                }
                if (!name.matches("^\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*$")) {
                    throw new NameFormatException("Name is not format, again: ");
                }
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Enter Date of birth:");
        ValidateDateOfBirth.MyDate dateOfBirth = ValidateDateOfBirth.getDateInfo(18, 100);
        dateOfBirth.getStrDate();
        String gender;
        while (true) {
            try {
                System.out.println("Enter gender:");
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
                System.out.println("Enter ID Card");
                idCard = scanner.nextLine();
                if (!idCard.matches("^[0-9]{9}$")) {
                    throw new Exception("ID Card is not format, again: ");
                }
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        String phone;
        while (true) {
            try {
                System.out.println("Enter phone");
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
                System.out.println("Enter email");
                email = scanner.nextLine();
                if (!email.matches("^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+([A-Za-z0-9]+\\.)+(com)$")) {
                    throw new Exception("Email is not format, again: ");
                }
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        String employeeID;
        while (true) {
            try {
                System.out.println("Enter Employee ID:");
                employeeID = scanner.nextLine();
                if (!employeeID.matches("^[0-9]{4}$")) {
                    throw new Exception("Employee Code is not format, again: ");
                }
                for (Employee employee : employees) {
                    if (employee.getEmployeeID().contains(employeeID)) {
                        throw new Exception("ID is duplicated!, again: ");
                    }
                }
                employeeID = "EP" + employeeID;
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        String level = "";
        while (true) {
            try {
                boolean check = false;
                System.out.println("Enter select option: " +
                        "\n 1. Intermediate" +
                        "\n 2. College" +
                        "\n 3. Campus" +
                        "\n 4. AfterCampus");
                int choice1 = Integer.parseInt(scanner.nextLine());
                switch (choice1) {
                    case 1:
                        level = "Intermediate";
                        check = true;
                        break;
                    case 2:
                        level = "College";
                        check = true;
                        break;
                    case 3:
                        level = "Campus";
                        check = true;
                        break;
                    case 4:
                        level = "AfterCampus";
                        check = true;
                        break;
                    default:
                        System.out.println("Your selection is not suitable, selection from 1 to 4");
                        check = false;
                }
                if (check) {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Input invalid");
            }
        }
        String locus = "";
        while (true) {
            try {
                boolean check = false;
                System.out.println("Enter select option: " +
                        "\n 1. Receptionist" +
                        "\n 2. Waiter" +
                        "\n 3. Expert" +
                        "\n 4. Supervision" +
                        "\n 5. Manager" +
                        "\n 6. Principal");
                int choice2 = Integer.parseInt(scanner.nextLine());
                switch (choice2) {
                    case 1:
                        locus = "Receptionist";
                        check = true;
                        break;
                    case 2:
                        locus = "Waiter";
                        check = true;
                        break;
                    case 3:
                        locus = "Expert";
                        check = true;
                        break;
                    case 4:
                        locus = "Supervision";
                        check = true;
                        break;
                    case 5:
                        locus = "Manager";
                        check = true;
                        break;
                    case 6:
                        locus = "Principal";
                        check = true;
                        break;
                    default:
                        System.out.println("Your selection is not suitable, selection from 1 to 6");
                        check = false;
                }
                if (check) {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Input invalid");
            }
        }
        double wage;
        while (true) {
            try {
                System.out.println("Enter Wage");
                wage = Double.parseDouble(scanner.nextLine());
                if (Double.isNaN(wage)) {
                    throw new NumberFormatException("Wage is not format, again: ");
                }
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return new Employee(name, dateOfBirth.getStrDate(), gender, idCard, phone, email, employeeID, level, locus, wage);
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
    public void editEmployee() throws IOException {
        employees = readEmployeeFile(PATH_LIST_EMPLOYEES);
        Employee employee = this.findEmployeeByID();
        if (employee == null) {
            System.out.println("Not found");
        } else {
            int index = employees.indexOf(employee);
            System.out.println("1. Edit all.");
            System.out.println("2. Edit each one.");
            int choiceEdit = Integer.parseInt(inputValidChoiceEdit());
            if (choiceEdit == 1) {
                employees.set(index, infoEmployee());
                System.out.println("Edited success");
                writeEmployeeFile(PATH_LIST_EMPLOYEES, employees);
            } else if (choiceEdit == 2) {
                while (true) {
                    System.out.println("" +
                            "1.\tEdit name\n" +
                            "2.\tEdit Date of birth\n" +
                            "3.\tEdit Gender\n" +
                            "4.\tEdit ID Card\n" +
                            "5.\tEdit Phone\n" +
                            "6.\tEdit Email\n" +
                            "7.\tEdit EmployeeCode\n" +
                            "8.\tEdit Level\n" +
                            "9.\tEdit Locus\n" +
                            "10.\tEdit Wage\n" +
                            "11.\tExit.\n" +
                            "\tEnter function\n");
                    int choice = Integer.parseInt(inputValidChoice());
                    switch (choice) {
                        case 1:
                            String name;
                            while (true) {
                                try {
                                    System.out.print("Enter name: ");
                                    name = scanner.nextLine();
                                    String str;
                                    if (!name.matches("\\D{5,50}")) {
                                        throw new NameFormatException("Name is not format, again: ");
                                    }
                                    if (!name.matches("^\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*$")) {
                                        throw new NameFormatException("Name is not format, again: ");
                                    }
                                    employees.get(index).setName(name);
                                    break;
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                            }
                            break;
                        case 2:
                            System.out.println("Enter Date of birth:");
                            ValidateDateOfBirth.MyDate dateOfBirth = ValidateDateOfBirth.getDateInfo(18, 100);
                            employees.get(index).setDateOfBirth(dateOfBirth.getStrDate());
                            break;
                        case 3:
                            String gender;
                            while (true) {
                                try {
                                    System.out.print("Enter gender");
                                    gender = scanner.nextLine();
                                    if (!gender.equals("Male") && (!gender.equals("Female"))) {
                                        throw new GenderException("Gender is not format, again: ");
                                    }
                                    employees.get(index).setGender(gender);
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
                                    employees.get(index).setIdCard(idCard);
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
                                    System.out.println("Enter phone");
                                    phone = scanner.nextLine();
                                    if (!phone.matches("^[(][0-9]{2}[)][-][0][0-9]{8}$")) {
                                        throw new Exception("Phone is not format, again: ");
                                    }
                                    employees.get(index).setPhone(phone);
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
                                    System.out.println("Enter email");
                                    email = scanner.nextLine();
                                    if (!email.matches("^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+([A-Za-z0-9]+\\.)+(com)$")) {
                                        throw new Exception("Email is not format, again: ");
                                    }
                                    employees.get(index).setEmail(email);
                                    break;
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                            }
                            break;
                        case 7:
                            String employeeID;
                            while (true) {
                                try {
                                    System.out.println("Enter Employee ID: ");
                                    employeeID = scanner.nextLine();
                                    if (!employeeID.matches("[0-9]{4}")) {
                                        throw new Exception("Employee Code is not format, again: ");
                                    }
                                    for (Employee employee1 : employees) {
                                        if (employee1.getEmployeeID().contains(employeeID)) {
                                            throw new Exception("ID is duplicated!, again: ");
                                        }
                                    }
                                    employeeID = "EP" + employeeID;
                                    employees.get(index).setEmployeeID(employeeID);
                                    break;
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                            }
                            break;
                        case 8:
                            String level = " ";
                            while (true) {
                                try {
                                    boolean check = false;
                                    System.out.println("Enter select option: " +
                                            "\n 1. Intermediate" +
                                            "\n 2. College" +
                                            "\n 3. Campus" +
                                            "\n 4. AfterCampus");
                                    int choice1 = Integer.parseInt(scanner.nextLine());
                                    switch (choice1) {
                                        case 1:
                                            level = "Intermediate";
                                            check = true;
                                            break;
                                        case 2:
                                            level = "College";
                                            check = true;
                                            break;
                                        case 3:
                                            level = "Campus";
                                            check = true;
                                            break;
                                        case 4:
                                            level = "AfterCampus";
                                            check = true;
                                            break;
                                        default:
                                            System.out.println("Your selection is not suitable, selection from 1 to 4");
                                            check = false;
                                    }
                                    if (check) {
                                        break;
                                    }
                                } catch (NumberFormatException e) {
                                    System.out.println("Input invalid");
                                }
                            }
                            employees.get(index).setLevel(level);
                            break;
                        case 9:
                            String locus = " ";
                            while (true) {
                                try {
                                    boolean check = false;
                                    System.out.println("Enter select option: " +
                                            "\n 1. Receptionist" +
                                            "\n 2. Waiter" +
                                            "\n 3. Expert" +
                                            "\n 4. Supervision" +
                                            "\n 5. Manager" +
                                            "\n 6. Principal");
                                    int choice2 = Integer.parseInt(scanner.nextLine());
                                    switch (choice2) {
                                        case 1:
                                            locus = "Receptionist";
                                            check = true;
                                            break;
                                        case 2:
                                            locus = "Waiter";
                                            check = true;
                                            break;
                                        case 3:
                                            locus = "Expert";
                                            check = true;
                                            break;
                                        case 4:
                                            locus = "Supervision";
                                            check = true;
                                            break;
                                        case 5:
                                            locus = "Manager";
                                            check = true;
                                            break;
                                        case 6:
                                            locus = "Principal";
                                            check = true;
                                            break;
                                        default:
                                            System.out.println("Your selection is not suitable, selection from 1 to 6");
                                            check = false;
                                    }
                                    if (check) {
                                        break;
                                    }
                                } catch (NumberFormatException e) {
                                    System.out.println("Input invalid");
                                }
                            }
                            employees.get(index).setLocus(locus);
                            break;
                        case 10:
                            double wage;
                            while (true) {
                                try {
                                    System.out.println("Enter Wage: ");
                                    wage = Double.parseDouble(scanner.nextLine());
                                    if (Double.isNaN(wage)) {
                                        throw new NumberFormatException("Wage is not format, again:");
                                    }
                                    employees.get(index).setWage(wage);
                                    break;
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                            }
                            break;
                        case 11:
                            return;
                        default:
                            System.out.println("You entered invalid! ");
                            return;
                    }
                    System.out.println("Edited success");
                    writeEmployeeFile(PATH_LIST_EMPLOYEES, employees);
                    break;
                }
            }
        }
    }

    private Employee findEmployeeByID() throws IOException {
        employees = readEmployeeFile(PATH_LIST_EMPLOYEES);
        System.out.println("Enter Employee ID: ");
        String id = scanner.nextLine();
        for (Employee employee : employees) {
            if (employee.getEmployeeID().equals(id)) {
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
            employees.add(new Employee(info[0], info[1], info[2], (info[3]), (info[4]), info[5], info[6], info[7], info[8], Double.parseDouble(info[9])));
        }
        return employees;
    }

    public static void writeEmployeeFile(String path, List<Employee> employees) throws IOException {
        String data = "";
        for (Employee employee : employees) {
            data += employee.toString();
            data += "\n";
        }
        WriteFileUlti.writeFile(path, data);
    }
}
