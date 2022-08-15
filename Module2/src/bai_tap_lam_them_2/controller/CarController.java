//package bai_tap_lam_them_2.controller;
//
//import bai_tap_lam_them_2.service.ICarService;
//import bai_tap_lam_them_2.service.impl.CarService;
//
//import java.util.Scanner;
//
//public class CarController {
//    private static Scanner scanner = new Scanner(System.in);
//    private ICarService carService = new CarService();
//
//    public void menuManagementCar() {
//        while (true) {
//            System.out.println("--------------------------------");
//            System.out.println("Quản lí xe máy");
//            System.out.println("1. Thêm mới phương tiện ");
//            System.out.println("2. Hiển thị phương tiện");
//            System.out.println("3. Xóa phương tiện");
//            System.out.println("4. Tìm kiếm theo biển kiểm soát");
//            System.out.println("5. Thoát");
//            System.out.println("Mời bạn nhập chức năng");
//            int choice = Integer.parseInt(scanner.nextLine());
//            switch (choice) {
//                case 1:
//                    carService.addCar();
//                    break;
//                case 2:
//                    carService.displayCar();
//                    break;
//                case 3:
//                    carService.deleteCar();
//                    break;
//                case 4:
//                    carService.findCar();
//                    break;
//                case 5:
//                    return;
//                default:
//                    System.out.println("Lựa chọn không đúng nhập lại");
//            }
//        }
//    }
//}
