package case_study.service.impl.Facility;

import case_study.model.facility.FacilityRoom;
import case_study.model.facility.FacilityVilla;

import java.util.Scanner;

public class FacilityRoomService {
    static Scanner scanner = new Scanner(System.in);
    static FacilityService facilityService = new FacilityService();

    public static FacilityRoom addRoomService() {
        String serviceID;
        while (true) {
            try {
                System.out.println("Enter Service ID Room:");
                serviceID = scanner.nextLine();
                if (facilityService.findServiceByID(serviceID) != null) {
                    throw new Exception("ID is duplicated, again! ");
                }
                if (!serviceID.matches("^[0-9]{4}$")) {
                    throw new Exception("ServiceID is not format, again! ");
                }
                serviceID = "SVRO-" + serviceID;
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
                if (!serviceName.matches("^[A-Z]{1}[a-z]{4,}$")) {
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
                if (usingArea < 30) {
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
                if (price < 0) {
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
                if (maximumPeople < 0 || maximumPeople > 20) {
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
        String rentalType;
        while (true) {
            try {
                System.out.println("Rental Type: " + "\nYear" + "\nMonth" + "\nDay" + "\nHour" + "\nEnter Rental Type: ");
                rentalType = scanner.nextLine();
                if (!rentalType.equals("Year") && (!rentalType.equals("Month")
                        && (!rentalType.equals("Day") && (!rentalType.equals("Hour"))))) {
                    throw new Exception("Data is not format, again: ");
                }
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        String freeService;
        while (true) {
            try {
                System.out.println("Enter Free Service:");
                freeService = scanner.nextLine();
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return new FacilityRoom(serviceID, serviceName, usingArea, price, maximumPeople, rentalType, freeService);

    }
}
