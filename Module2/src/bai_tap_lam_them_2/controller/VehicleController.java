package bai_tap_lam_them_2.controller;

import java.util.Scanner;

public class VehicleController {
    Scanner scanner = new Scanner(System.in);
    BikeController bikeController = new BikeController();
    CarController carController = new CarController();
    TruckController truckController = new TruckController();

    public void menuManagement() {
        while (true) {
            System.out.println("----------------------------------------------------");
            System.out.println("Công an giao thông TP ĐÀ NẴNG");
            System.out.println("1. Quản lí xe máy");
            System.out.println("2. Quản lí xe ô tô");
            System.out.println("3. Quản lí xe tải");
            System.out.println("Mời bạn nhập chức năng");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 1) {
                bikeController.menuManagementBike();
            } else if (choice == 2) {
                carController.menuManagementCar();
            } else if (choice == 3) {
                truckController.menuManagementTruck();
            } else {
                System.out.println("Nhập lại chức năng");
            }
        }
    }
}
