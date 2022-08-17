package bai_tap_lam_them_2.controller;

import bai_tap_lam_them_2.model.Bike;
import bai_tap_lam_them_2.model.Car;
import bai_tap_lam_them_2.model.Truck;
import bai_tap_lam_them_2.model.Vehicle;
import bai_tap_lam_them_2.service.IBikeService;
import bai_tap_lam_them_2.service.ICarService;
import bai_tap_lam_them_2.service.ITruckService;
import bai_tap_lam_them_2.service.IVehicleService;
import bai_tap_lam_them_2.service.impl.BikeService;
import bai_tap_lam_them_2.service.impl.CarService;
import bai_tap_lam_them_2.service.impl.TruckService;
import bai_tap_lam_them_2.service.impl.VehiCleService;

import java.util.Scanner;

public class VehicleController {
    Scanner scanner = new Scanner(System.in);
    IBikeService bikeService = new BikeService();
    ITruckService truckService = new TruckService();
    ICarService carService = new CarService();
    IVehicleService vehiCleService = new VehiCleService();

    public void menuManagement() {
        while (true) {
            System.out.println("----------------------------------------------------");
            System.out.println("Công an giao thông TP ĐÀ NẴNG");
            System.out.println("1. Thêm mới phương tiên");
            System.out.println("2. Hiển thị phương tiện");
            System.out.println("3. Xóa phương tiện");
            System.out.println("4. Tìm kiếm phương tiện");
            System.out.println("5. Thoát");
            System.out.println("Mời bạn nhập chức năng");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("1. Thêm xe tải");
                    System.out.println("2. Thêm ô tô");
                    System.out.println("3. Thêm xe máy");
                    System.out.println("4. Thoát");
                    int choice1 = Integer.parseInt(scanner.nextLine());
                    switch (choice1) {
                        case 1:
                            Truck truck = truckService.addTruck();
                            vehiCleService.addVehicle(truck);
                            break;
                        case 2:
                            Car car = carService.addCar();
                            vehiCleService.addVehicle(car);
                            break;
                        case 3:
                            Bike bike = bikeService.addBike();
                            vehiCleService.addVehicle(bike);
                            break;
                        case 4:
                            break;
                    }
                    break;
                case 2:
                    System.out.println("1. Hiển thị xe tải");
                    System.out.println("2. Hiển thị ô tô");
                    System.out.println("3. Hiển thị xe máy");
                    System.out.println("4. Thoát");
                    int choice2 = Integer.parseInt(scanner.nextLine());
                    switch (choice2) {
                        case 1:
                            truckService.displayTruck();
                            break;
                        case 2:
                            carService.displayCar();
                            break;
                        case 3:
                            bikeService.displayBike();
                            break;
                        case 4:
                            break;
                    }
                    break;
                case 3:
                    System.out.println("Nhập vào biển kiểm soát");
                    String licensePlates = scanner.nextLine();
                    if (vehiCleService.searchVehicle(licensePlates) instanceof Truck) {
                        truckService.deleteTruck(licensePlates);
                    }
                    if (vehiCleService.searchVehicle(licensePlates) instanceof Car) {
                        carService.deleteCar(licensePlates);
                    }
                    if (vehiCleService.searchVehicle(licensePlates) instanceof Bike) {
                        bikeService.deleteBike(licensePlates);
                    }
                    vehiCleService.deleteVehicle(licensePlates);
                    break;
                case 4:
                    vehiCleService.findVehicle();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Lựa chọn sai vui lòng nhập lại");
            }
        }
    }
}
