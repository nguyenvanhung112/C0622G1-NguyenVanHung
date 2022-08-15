package bai_tap_lam_them_2.service.impl;


import bai_tap_lam_them_2.model.*;
import bai_tap_lam_them_2.service.IVehicleService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VehiCleService implements IVehicleService {
    private static Scanner scanner = new Scanner(System.in);
    public static List<Vehicle> vehicles = new ArrayList<>();

    @Override
    public void findVehicle() {
        Vehicle vehicle = this.searchVehicle();
        if (vehicle == null) {
            System.out.println("Không tìm thấy");
        }
        System.out.println(vehicle);
    }
    public Vehicle searchVehicle() {
        vehicles.addAll(BikeService.bikes);
        vehicles.addAll(TruckService.trucks);
        vehicles.addAll(CarService.cars);
        System.out.println("Nhập vào biển kiểm soát");
        String licensePlates = scanner.nextLine();
        for (Vehicle vehicle : vehicles
        ) {
            if (vehicle.getLicensePlates().equals(licensePlates)) {
                return vehicle;
            }
        }
        return null;
    }
    @Override
    public void deleteVehicle() {

    }
}