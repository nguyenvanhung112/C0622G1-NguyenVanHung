package case_study.service.impl.Facility;

import case_study.model.facility.Facility;
import case_study.model.facility.FacilityHouse;
import case_study.model.facility.FacilityRoom;
import case_study.model.facility.FacilityVilla;
import case_study.model.person.Customer;
import case_study.service.IFacilityService;
import case_study.utils.ReadFileUlti;
import case_study.utils.WriteFileUlti;

import java.io.IOException;
import java.util.*;

public class FacilityService implements IFacilityService {
    public static Map<Facility, Integer> facilities = new LinkedHashMap<>();
    public static Map<Facility, Integer> facilitiesMaintenance = new LinkedHashMap<>();
    private static Scanner scanner = new Scanner(System.in);
    private static final String FACILITY_LIST = "src\\case_study\\data\\facility";

    @Override
    public void displayListFacilitys() throws IOException {
        facilities = readFacilityFile(FACILITY_LIST);
        if (facilities.size() == 0) {
            System.out.println("List is empty!");
        } else {
            System.out.println("List Facility: ");
            Set<Facility> facilitySet = facilities.keySet();
            for (Facility facility : facilitySet) {
                System.out.println(facility.toString() + "," + facilities.get(facility));
            }
        }
    }

    @Override
    public void addNewFacility() throws IOException {
        facilities = readFacilityFile(FACILITY_LIST);
        while (true) {
            System.out.println("" +
                    "1.\tAdd New Villa\n" +
                    "2.\tAdd New House\n" +
                    "3.\tAdd New Room\n" +
                    "4.\tReturn main menu\n" +
                    "\tEnter function\n");
            int choice = Integer.parseInt(inputValidChoice());
            switch (choice) {
                case 1:
                    FacilityVilla villa = FacilityVillaService.addVillaService();
                    facilities.put(villa, 0);
                    System.out.println("Add new success!");
                    break;
                case 2:
                    FacilityHouse house = FacilityHouseService.addHouseService();
                    facilities.put(house, 0);
                    System.out.println("Add new success!");
                    break;
                case 3:
                    FacilityRoom room = FacilityRoomService.addRoomService();
                    facilities.put(room, 0);
                    System.out.println("Add new success!");
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Enter the correct function");
            }
            writeFacilityFile(FACILITY_LIST, facilities);
        }
    }

    @Override
    public void displayListFacilitysMaintenance() throws IOException {
        facilities = readFacilityFile(FACILITY_LIST);
        for (Facility facility : facilities.keySet()) {
            if (facilities.get(facility) >= 5) {
                facilitiesMaintenance.put(facility, facilities.get(facility));
            }
        }
        for (Facility facility : facilitiesMaintenance.keySet()) {
            System.out.println(facility + " has been used: " + facilitiesMaintenance.get(facility) + " times");
        }
        writeFacilityFile(FACILITY_LIST,facilities);
    }

    @Override
    public void facilityMaintenance() throws IOException {
        facilities = readFacilityFile(FACILITY_LIST);
        for (Facility facility : facilities.keySet()) {
            if (facilities.get(facility) >= 5) {
                facilities.replace(facility, 0);
            }
        }
        facilitiesMaintenance.clear();
        System.out.println("Successful maintenance!");
        writeFacilityFile(FACILITY_LIST,facilities);
    }

    public static String inputValidChoice() {
        while (true) {
            String choiceString = scanner.nextLine();
            if (choiceString.matches("[1-4]")) {
                return choiceString;
            } else {
                System.out.print("You entered invalid! Again: ");
            }
        }
    }


    public Facility findServiceByID(String id) {
        Set<Facility> facilitySet = facilities.keySet();
        for (Facility facility : facilitySet) {
            if (facility.getServiceID().contains(id)) {
                return facility;
            }
        }
        return null;
    }

    public static Map<Facility, Integer> readFacilityFile(String path) throws IOException {
        List<String> strings = ReadFileUlti.readFile(path);
        Map<Facility, Integer> facilityList = new LinkedHashMap<>();
        String[] info;
        for (String line : strings) {
            info = line.split(",");
            if (info[0].contains("SVVL")) {
                facilityList.put((new FacilityVilla(info[0], info[1], Double.parseDouble(info[2]), Double.parseDouble(info[3]), Integer.parseInt(info[4]), info[5], info[6], Double.parseDouble(info[7]), Integer.parseInt(info[8]))), Integer.parseInt(info[9]));
            } else if (info[0].contains("SVHO")) {
                facilityList.put(new FacilityHouse(info[0], info[1], Double.parseDouble(info[2]), Double.parseDouble(info[3]), Integer.parseInt(info[4]), info[5], info[6], Integer.parseInt(info[7])), Integer.parseInt(info[8]));
            } else if (info[0].contains("SVRO")) {
                facilityList.put(new FacilityRoom(info[0], info[1], Double.parseDouble(info[2]), Double.parseDouble(info[3]), Integer.parseInt(info[4]), info[5], info[6]), Integer.parseInt(info[7]));
            }
        }
        return facilityList;
    }

    public static void writeFacilityFile(String path, Map<Facility, Integer> facilities) throws IOException {
        String data = "";
        Set<Facility> facilitySet = facilities.keySet();
        for (Facility facility : facilitySet) {
            data += facility.toString() + "," + facilities.get(facility);
            data += "\n";
        }
        WriteFileUlti.writeFile(path, data);
    }
}
