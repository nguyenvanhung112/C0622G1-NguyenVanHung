package case_study.service.impl;

import bai_tap_lam_them.model.Student;
import bai_tap_lam_them.ulti.ReadFileUlti;
import case_study.model.person.Employee;
import case_study.service.IEmployeeService;
import case_study.utils.DateOfBirthException;
import case_study.utils.GenderException;
import case_study.utils.LevelException;
import case_study.utils.LocusException;
import case_study.utils.StringFormatException;
import ulti_exception.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static bai_tap_lam_them.ulti.WriteFileUlti.writeFile;
import static java.lang.Double.NaN;
import static java.lang.Double.isNaN;

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
        int idCard = Integer.parseInt(scanner.nextLine());
        System.out.println("Input phone");
        int phone = Integer.parseInt(scanner.nextLine());
        System.out.println("Input Email");
        String email = scanner.nextLine();
        System.out.println("Input Employee code");
        String employeeCode = scanner.nextLine();
        String level;
        while (true) {
            try {
                System.out.println("Input Level\n" + "\nTrung cấp" + "\nCao đẳng" + "\nĐại học" + "\nSau đại học" + "\nChọn trình độ:\n");
                level = scanner.nextLine();
                if (!level.equals("Trung cấp") && (!level.equals("Cao đẳng")
                        && (!level.equals("Đại học") && (!level.equals("Sau đại học"))))) {
                    throw new LevelException("Dữ liệu nhập không đúng");
                }
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        String locus;
        while (true) {
            try {
                System.out.println("Input Locus\n" + "\nLễ tân" + "\nPhục vụ" + "\nChuyên viên" +
                        "\nGiám sát" + "\nQuản lí" + "\nGiám đốc" + "\nChọn vị trí:\n");
                locus = scanner.nextLine();
                if (!locus.equals("Lễ tân") && (!locus.equals("Phục vụ")
                        && (!locus.equals("Chuyên viên") && (!locus.equals("Giám sát") &&
                        (!locus.equals("Quản lí") && (!locus.equals("Giám đốc"))))))) {
                    throw new LocusException("Dữ liệu nhập không đúng");
                }
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
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
                int choice4 = Integer.parseInt(scanner.nextLine());
                switch (choice4) {
                    case 1:
                        String name;
                        while (true) {
                            try {
                                System.out.print("Enter name ");
                                name = scanner.nextLine();
                                String str;
                                for (int i = 0; i < name.length(); i++) {
                                    str = "";
                                    if ((str + name.charAt(i)).matches("\\d+")) {
                                        throw new StringFormatException("Data is not format");
                                    }
                                }
                                employees.get(index).setName(name);
                                break;
                            } catch (StringFormatException e) {
                                System.out.println(e.getMessage());
                            } catch (Exception e) {
                                System.out.println("Error");
                            }
                        }
                        break;
                    case 2:
                        String dateOfBirth;
                        while (true) {
                            try {
                                System.out.print("Mời bạn nhập ngày sinh: ");
                                dateOfBirth = scanner.nextLine();
                                if (!dateOfBirth.matches("\\d+\\d+\\W+\\d+\\d+\\W+\\d+\\d+\\d+\\d")) {
                                    throw new DateOfBirthException("Data is not format");
                                }
                                if (Integer.parseInt(dateOfBirth.substring(6)) > 2016) {
                                    throw new DateOfBirthException("Incorrect data");
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
                                if (!gender.equals("Nam") && (!gender.equals("Nữ"))) {
                                    throw new GenderException("Data is not format");
                                }
                                employees.get(index).setGender(gender);
                                break;
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                        }
                        break;
                    case 4:
                        int idCard;
                        while (true){
                            try {
                                System.out.println("Enter ID Card");
                                idCard = Integer.parseInt(scanner.nextLine());
                               if (Double.isNaN(idCard)){
                                   throw new NumberFormatException();
                               }
                                employees.get(index).setIdCard(idCard);
                               break;
                            } catch (NumberFormatException e){
                                System.out.println("Data is not format");
                            } catch (Exception e){
                                System.out.println(e.getMessage());
                            }
                        }
                        break;
                    case 5:
                        System.out.println("Enter phone");
                        int phone = Integer.parseInt(scanner.nextLine());
                        employees.get(index).setPhone(phone);
                        break;
                    case 6:
                        System.out.println("Enter Email");
                        String email = scanner.nextLine();
                        employees.get(index).setEmail(email);
                        break;
                    case 7:
                        System.out.println("Enter EmployeeCode");
                        String employeeCode = scanner.nextLine();
                        employees.get(index).setEmployeeCode(employeeCode);
                        break;
                    case 8:
                        String level;
                        while (true) {
                            try {
                                System.out.println("Enter Level\n" + "\nTrung cấp" + "\nCao đẳng" + "\nĐại học" + "\nSau đại học" + "\nChọn trình độ:\n");
                                level = scanner.nextLine();
                                if (!level.equals("Trung cấp") && (!level.equals("Cao đẳng")
                                        && (!level.equals("Đại học") && (!level.equals("Sau đại học"))))) {
                                    throw new LevelException("Dữ liệu nhập không đúng");
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
                                System.out.println("Enter Locus\n" + "\nLễ tân" + "\nPhục vụ" + "\nChuyên viên" +
                                        "\nGiám sát" + "\nQuản lí" + "\nGiám đốc" + "\nChọn vị trí:\n");
                                locus = scanner.nextLine();
                                if (!locus.equals("Lễ tân") && (!locus.equals("Phục vụ")
                                        && (!locus.equals("Chuyên viên") && (!locus.equals("Giám sát") &&
                                        (!locus.equals("Quản lí") && (!locus.equals("Giám đốc"))))))) {
                                    throw new LocusException("Dữ liệu nhập không đúng");
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
                                System.out.println("Enter Wage");
                                wage = Double.parseDouble(scanner.nextLine());
                                if (Double.isNaN(wage)) {
                                    throw new NumberFormatException();
                                }
                                employees.get(index).setWage(wage);
                                break;
                            } catch (NumberFormatException e) {
                                System.out.println("Data is not number, again!");
                            } catch (Exception e) {
                                System.out.println("Error");
                            }
                        }
                        break;
                    case 11:
                        return;
                    default:
                        System.out.println("Enter the correct function");
                }
                System.out.println("Edit success");
                break;
            }
            writeEmployeeFile(PATH_LIST_EMPLOYEES, employees);
        }
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
                employees.add(new Employee(info[0], info[1], info[2], Integer.parseInt(info[3]),
                        Integer.parseInt(info[4]), info[5], info[6], info[7], info[8], Double.parseDouble(info[9])));
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
