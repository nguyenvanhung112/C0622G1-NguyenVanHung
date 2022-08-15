package bai_tap_lam_them_2.controller;

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
//    BikeController bikeController = new BikeController();
//    CarController carController = new CarController();
//    TruckController truckController = new TruckController();
    IBikeService bikeService = new BikeService();
    ITruckService truckService = new TruckService();
    ICarService carService = new CarService();
    IVehicleService vehicle = new VehiCleService();

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
            switch (choice){
                case 1:
                    System.out.println("1. Thêm xe tải");
                    System.out.println("2. Thêm ô tô");
                    System.out.println("3. Thêm xe máy");
                    System.out.println("4. Thoát");
                    int choice1 = Integer.parseInt(scanner.nextLine());
                    switch (choice1){
                        case 1:
                            truckService.addTruck();
                            break;
                        case 2:
                            carService.addCar();
                            break;
                        case 3:
                            bikeService.addBike();
                            break;
                        case 4:
                            return;
                    }
                    break;
                case 2:
                    System.out.println("1. Hiển thị xe tải");
                    System.out.println("2. Hiển thị ô tô");
                    System.out.println("3. Hiển thị xe máy");
                    System.out.println("4. Thoát");
                    int choice2 = Integer.parseInt(scanner.nextLine());
                    switch (choice2){
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
                            return;
                    }
                    break;
                case 3:
                    vehicle.deleteVehicle();
                    break;
                case 4:
                    vehicle.findVehicle();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Lựa chọn sai vui lòng nhập lại");
            }
        }
    }
}
