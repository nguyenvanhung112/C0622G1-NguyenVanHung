package case_study.service.impl;

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


import static java.lang.Double.NaN;
import static java.lang.Double.isNaN;

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
                for (int i = 0; i < name.length(); i++) {
                    str = "";
                    if ((str + name.charAt(i)).matches("\\d+")) {
                        throw new NameFormatException("Name is not format, again: ");
                    }
                }
                String[] name1 = name.split("");
                for (int i = 0; i < name1.length; i++) {
                    if ((name1[i].equals(" ")) && (name1[i + 1].equals(" "))) {
                        throw new NameFormatException("Name is not format, again: ");
                    }
                }
                if (!name.matches("^[A-Z a-zvVxXyYỳọáầảấờễàạằệếýộậốũứĩõúữịỗìềểẩớặòùồợãụủíỹắẫựỉỏừỷởóéửỵẳẹèẽổẵẻỡơôưăêâđĐ]{5,50}$")) {
                    throw new NameFormatException("Name is not format, again: ");
                }
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        String dateOfBirth;
        while (true) {
            try {
                System.out.println("Enter Date of birth: ");
                dateOfBirth = scanner.nextLine();
                if (!dateOfBirth.matches("\\d+\\d+\\W+\\d+\\d+\\W+\\d+\\d+\\d+\\d")) {
                    throw new DateOfBirthException("Date of birth is not format, again: ");
                }
                if (Integer.parseInt(dateOfBirth.substring(6)) > 2016) {
                    throw new DateOfBirthException("Date of birth is not format, again: ");
                }
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
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
                employeeID = "EP" + employeeID;
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        String level;
        while (true) {
            try {
                System.out.println("Level: " + "\nIntermediate" + "\nCollege" + "\nCampus" + "\n AfterCampus" + "\n Enter Level:\n");
                level = scanner.nextLine();
                if (!level.equals("Intermediate") && (!level.equals("College")
                        && (!level.equals("Campus") && (!level.equals("AfterCampus"))))) {
                    throw new LevelException("Level is not format, again: ");
                }
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        String locus;
        while (true) {
            try {
                System.out.println("Locus: " + "\nReceptionist" + "\nWaiter" + "\nExpert" +
                        "\nSupervision" + "\nManager" + "\nPrincipal" + "\nEnter Locus:\n");
                locus = scanner.nextLine();
                if (!locus.equals("Receptionist") && (!locus.equals("Waiter")
                        && (!locus.equals("Expert") && (!locus.equals("Supervision") &&
                        (!locus.equals("Manager") && (!locus.equals("principal"))))))) {
                    throw new LocusException("Locus is not format, again: ");
                }
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
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
        return new Employee(name, dateOfBirth, gender, idCard, phone, email, employeeID, level, locus, wage);
    }

    public static String inputValidChoice() {
        final String VALID_FORMAT = "[1-11]";
        while (true) {
            String choiceString = scanner.nextLine();
            if (choiceString.matches(VALID_FORMAT)) {
                return choiceString;
            } else {
                System.out.print("You entered invalid! Again: ");
            }
        }
    }

    @Override
    public void editEmployee() throws IOException {
        employees = readEmployeeFile(PATH_LIST_EMPLOYEES);
        Employee employee = this.findEmployee();
        if (employee == null) {
            System.out.println("Not found");
        } else {
            int index = employees.indexOf(employee);
            while (true) {
                System.out.println("" +
                        "1.\tEdit name\n" +
                        "2.\tEdit Date of birth\n" +
                        "3.\tEdit gender\n" +
                        "4.\tEdit ID Card\n" +
                        "5.\tEdit phone\n" +
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
                                for (int i = 0; i < name.length(); i++) {
                                    str = "";
                                    if ((str + name.charAt(i)).matches("\\d+")) {
                                        throw new NameFormatException("Name is not format, again: ");
                                    }
                                }
                                String[] name1 = name.split("");
                                for (int i = 0; i < name1.length; i++) {
                                    if ((name1[i].equals(" ")) && (name1[i + 1].equals(" "))) {
                                        throw new NameFormatException("Name is not format, again: ");
                                    }
                                }
                                if (!name.matches("^[A-Z a-zvVxXyYỳọáầảấờễàạằệếýộậốũứĩõúữịỗìềểẩớặòùồợãụủíỹắẫựỉỏừỷởóéửỵẳẹèẽổẵẻỡơôưăêâđĐ]{5,50}$")) {
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
                        String dateOfBirth;
                        while (true) {
                            try {
                                System.out.print("Enter Date of birth: ");
                                dateOfBirth = scanner.nextLine();
                                if (!dateOfBirth.matches("\\d+\\d+\\W+\\d+\\d+\\W+\\d+\\d+\\d+\\d")) {
                                    throw new DateOfBirthException("Date of birth is not format, again: ");
                                }
                                if (Integer.parseInt(dateOfBirth.substring(6)) > 2016) {
                                    throw new DateOfBirthException("Date of birth is not format, again: ");
                                }
                                employees.get(index).setDateOfBirth(dateOfBirth);
                                break;
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                        }
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
                                employeeID = "EP" + employeeID;
                                employees.get(index).setEmployeeCode(employeeID);
                                break;
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                        }
                        break;
                    case 8:
                        String level;
                        while (true) {
                            try {
                                System.out.println("Level: " + "\nIntermediate" + "\nCollege" + "\nCampus" + "\n AfterCampus" + "\n Enter Level:\n");
                                level = scanner.nextLine();
                                if (!level.equals("Intermediate") && (!level.equals("College")
                                        && (!level.equals("Campus") && (!level.equals("AfterCampus"))))) {
                                    throw new LevelException("Level is not format, again: ");
                                }
                                employees.get(index).setLevel(level);
                                break;
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                        }
                        break;
                    case 9:
                        String locus;
                        while (true) {
                            try {
                                System.out.println("Locus: " + "\nReceptionist" + "\nWaiter" + "\nExpert" +
                                        "\nSupervision" + "\nManager" + "\nPrincipal" + "\nEnter Locus:\n");
                                locus = scanner.nextLine();
                                if (!locus.equals("Receptionist") && (!locus.equals("Waiter")
                                        && (!locus.equals("Expert") && (!locus.equals("Supervision") &&
                                        (!locus.equals("Manager") && (!locus.equals("principal"))))))) {
                                    throw new LocusException("Locus is not format, again: ");
                                }
                                employees.get(index).setLocus(locus);
                                break;
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                        }
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
                        System.out.println("Again:");
                }
                System.out.println("Edited success");
                break;
            }
            writeEmployeeFile(PATH_LIST_EMPLOYEES, employees);
        }
    }

    private Employee findEmployee() throws IOException {
        employees = readEmployeeFile(PATH_LIST_EMPLOYEES);
        System.out.println("Nhập tên bạn muốn tìm");
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
