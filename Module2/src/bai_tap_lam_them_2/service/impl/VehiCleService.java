package bai_tap_lam_them_2.service.impl;


import bai_tap_lam_them_2.model.*;
import bai_tap_lam_them_2.service.IVehicleService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VehiCleService implements IVehicleService {
    private static Scanner scanner = new Scanner(System.in);

    @Override
    public void findVehicle() {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.addAll(BikeService.bikes);
        vehicles.addAll(TruckService.trucks);
        vehicles.addAll(CarService.cars);
        System.out.println("Nhập vào biển kiểm soát");
        String licensePlates = scanner.nextLine();
        List<Vehicle> foundVehicles = new ArrayList<>();
        for (Vehicle vehicle : vehicles
        ) {
            if (vehicle.getLicensePlates().equals(licensePlates)) {
                foundVehicles.add(vehicle);
            }
        }
        if (foundVehicles.isEmpty()) {
            System.out.println("Không tìm thấy");
        } else {
            for (Vehicle vehicle1 : foundVehicles
            ) {
                System.out.println(vehicle1);
            }
        }
    }


//    @Override
//    public void deleteVehicle() {
//        Vehicle vehicle = this.searchVehicle();
//        if (vehicle == null) {
//            System.out.println("Không tìm thấy");
//        } else {
//            System.out.println("Bạn có thực sự muốn xóa biển kiểm soát " + vehicle.getLicensePlates() + " không?");
//            System.out.println("1. Có");
//            System.out.println("2. Không");
//            int choice = Integer.parseInt(scanner.nextLine());
//            if (choice == 1) {
//                vehicles.remove(vehicle);
//                System.out.println("Xóa thành công");
//            }
//        }
//    }
//
//    private Vehicle searchVehicle() {
//        System.out.println("Nhập vào biển kiểm soát");
//        String licensePlates = scanner.nextLine();
//        for (Vehicle vehicle : vehicles
//        ) {
//            if (vehicle.getLicensePlates().equals(licensePlates)) {
//                return vehicle;
//            }
//        }
//        return null;
//    }
}