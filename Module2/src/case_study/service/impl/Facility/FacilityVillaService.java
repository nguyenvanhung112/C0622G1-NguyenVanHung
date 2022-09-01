package case_study.service.impl.Facility;

import case_study.model.facility.FacilityVilla;
import com.sun.org.apache.xml.internal.resolver.readers.ExtendedXMLCatalogReader;


import java.util.Scanner;

public class FacilityVillaService {
    static Scanner scanner = new Scanner(System.in);
    static FacilityService facilityService = new FacilityService();

    public static FacilityVilla addVillaService() {
        String serviceID;
        while (true) {
            try {
                System.out.println("Enter Service ID Villa:");
                serviceID = scanner.nextLine();
                if (facilityService.findServiceByID(serviceID) != null) {
                    throw new Exception("ID is duplicated, again! ");
                }
                if (!serviceID.matches("^[0-9]{4}$")) {
                    throw new Exception("ServiceID is not format, again: ");
                }
                serviceID = "SVVL-" + serviceID;
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        String serviceName;
        while (true) {
            try {
                System.out.println("Enter Service Name:");
                serviceName = scanner.nextLine();
                if (!serviceName.matches("^[A-Z][a-z]{4,}$")) {
                    throw new Exception("Service Name is not format, again: ");
                }
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        double usingArea;
        while (true) {
            try {
                System.out.println("Enter Using Area:");
                usingArea = Double.parseDouble(scanner.nextLine());
                if (usingArea < 30 || usingArea <= 0) {
                    throw new Exception("The area must be more than 30m2, again: ");
                }
                if (Double.isNaN(usingArea)) {
                    throw new NumberFormatException("The data you enter is not a number!");
                }
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        double price;
        while (true) {
            try {
                System.out.println("Enter Price:");
                price = Double.parseDouble(scanner.nextLine());
                if (price <= 0) {
                    throw new Exception("The area must be more than 0, again: ");
                }
                if (Double.isNaN(price)) {
                    throw new NumberFormatException("The data you enter is not a number!");
                }
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        int maximumPeople;
        while (true) {
            try {
                System.out.println("Enter Maximum People:");
                maximumPeople = Integer.parseInt(scanner.nextLine());
                if (maximumPeople <= 0 || maximumPeople > 20) {
                    throw new Exception("Number of people must be less than 20, again: ");
                }
                if (Double.isNaN(price)) {
                    throw new NumberFormatException("The data you enter is not a number!");
                }
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        String rentalType = "";
        while (true) {
            try {
                boolean check = false;
                System.out.println("Enter select option: " +
                        "\n 1. Year" +
                        "\n 2. Month" +
                        "\n 3. Day" +
                        "\n 4. Hour");
                int choice1 = Integer.parseInt(scanner.nextLine());
                switch (choice1) {
                    case 1:
                        rentalType = "Year";
                        check = true;
                        break;
                    case 2:
                        rentalType = "Month";
                        check = true;
                        break;
                    case 3:
                        rentalType = "Day";
                        check = true;
                        break;
                    case 4:
                        rentalType = "Hour";
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
        String roomStandard = "";
        while (true) {
            try {
                boolean check = false;
                System.out.println("Enter select option: " +
                        "\n 1. SuperStar" +
                        "\n 2. SuperVip" +
                        "\n 3. Vip" +
                        "\n 4. Normal");
                int choice1 = Integer.parseInt(scanner.nextLine());
                switch (choice1) {
                    case 1:
                        roomStandard = "SuperStar";
                        check = true;
                        break;
                    case 2:
                        roomStandard = "SuperVip";
                        check = true;
                        break;
                    case 3:
                        roomStandard = "Vip";
                        check = true;
                        break;
                    case 4:
                        roomStandard = "Normal";
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
        double poolArea;
        while (true) {
            try {
                System.out.println("Enter Pool Area:");
                poolArea = Double.parseDouble(scanner.nextLine());
                if (poolArea <= 0) {
                    throw new Exception("The area must be more than 0, again: ");
                }
                if (Double.isNaN(poolArea)) {
                    throw new NumberFormatException("The data you enter is not a number!");
                }
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        int numberFloor;
        while (true) {
            try {
                System.out.println("Enter floor:");
                numberFloor = Integer.parseInt(scanner.nextLine());
                if (numberFloor <= 0) {
                    throw new Exception("The floor must be more than 0, again: ");
                }
                if (Double.isNaN(numberFloor)) {
                    throw new NumberFormatException("The data you enter is not a number!");
                }
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return new FacilityVilla(serviceID, serviceName, usingArea, price, maximumPeople, rentalType, roomStandard, poolArea, numberFloor);
    }
}
