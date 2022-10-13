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
                if (usingArea < 30) {
                    throw new Exception("The area must be more than 30m2, again: ");
                }if (usingArea <= 0) {
                    throw new Exception("The area must be more than 0, again: ");
                }
                break;
            }catch (NumberFormatException e){
                System.out.println("The data you enter is not a number!");
            }catch (Exception e) {
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
                break;
            }catch (NumberFormatException e){
                System.out.println("The data you enter is not a number!");
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
                break;
            }catch (NumberFormatException e){
                System.out.println("The data you enter is not a number!");
            }catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        String rentalType ="";
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
