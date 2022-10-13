package bai_thi_module_2.service.impl;

import bai_thi_module_2.model.Customer;
import bai_thi_module_2.model.Student;
import bai_thi_module_2.service.IStudentService;
import case_study.model.Contract;
import ulti_exception.NameFormatException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.DuplicateFormatFlagsException;
import java.util.Scanner;

public class StudentService implements IStudentService {
    static Scanner scanner = new Scanner(System.in);
    static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    public Student addNewStudent() throws ParseException {

        String id;
        while (true) {
            try {
                System.out.println("Nhập ID");
                id = scanner.nextLine();
                if (!id.matches("[0-9]{3}")) {
                    throw new Exception("Contract is not format!");
                }
                for (Customer customer : CustomerService.customers) {
                    if (customer.getId().contains(id)) {
                        throw new DuplicateFormatFlagsException("ID trùng");
                    }
                }
                id = "HV-" + id;
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
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
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        Date dateOfBirth;
        while (true){
            try {
                System.out.println("Nhập vào ngày sinh");
                String dateOfBirth2 = scanner.nextLine();
                if (!dateOfBirth2.matches("^(?:(?:31([/\\-.])(?:0?[13578]|1[02]))\\1|" +
                        "(?:(?:29|30)([/\\-.])(?:0?[13-9]|1[0-2])\\2))" +
                        "(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29([/\\-.])0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)" +
                        "?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|" +
                        "^(?:0?[1-9]|1\\d|2[0-8])([/\\-.])(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$")){
                    throw new Exception("Không đúng định dạng");
                }
                dateOfBirth = dateFormat.parse(dateOfBirth2);
                break;
            }catch (Exception e){
                System.out.println(e.getMessage());
            }

        }
        String address;
        while (true) {
            try {
                System.out.println("Enter address: ");
                address = scanner.nextLine();
                if (!address.matches("\\D{5,100}")) {
                    throw new Exception("Address is not format, again: ");
                }
                if (!address.matches("^\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*$")) {
                    throw new Exception("Address is not format, again: ");
                }
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        String phone;
        while (true) {
            try {
                System.out.println("Nhập số điện thoại: ");
                phone = scanner.nextLine();
                if (!phone.matches("^[0-9]{10}$")) {
                    throw new Exception("Sai định dạng");
                }
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        double match;
        while (true) {
            try {
                System.out.println("Nhập vào điểm:");
                match = Double.parseDouble(scanner.nextLine());
                if (match < 0) {
                    throw new Exception("Điểm không được nhỏ hơn 0");
                }
                break;
            }catch (NumberFormatException e){
                System.out.println("Không phải là số");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        String study;
        while (true) {
            try {
                System.out.println("Nhập lớp: ");
                study = scanner.nextLine();
                if (!study.matches("^[A-Z a-z0-9]{10}$")) {
                    throw new Exception("Sai định dạng");
                }
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        Date date;
        while (true){
            try {
                System.out.println("Ngày nhập học");
                String date1 = scanner.nextLine();
                if (!date1.matches("^(?:(?:31([/\\-.])(?:0?[13578]|1[02]))\\1|" +
                        "(?:(?:29|30)([/\\-.])(?:0?[13-9]|1[0-2])\\2))" +
                        "(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29([/\\-.])0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)" +
                        "?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|" +
                        "^(?:0?[1-9]|1\\d|2[0-8])([/\\-.])(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$")){
                    throw new Exception("Không đúng định dạng");
                }
                date = dateFormat.parse(date1);
                break;
            }catch (Exception e){
                System.out.println(e.getMessage());
            }

        }
        Student student = new Student(id,name,dateOfBirth,address,phone,match,study,date);
        return student;
    }
}
