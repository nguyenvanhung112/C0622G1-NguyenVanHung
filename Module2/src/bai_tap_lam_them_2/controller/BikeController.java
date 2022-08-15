//package bai_tap_lam_them_2.controller;
//
//import bai_tap_lam_them_2.service.IBikeService;
//import bai_tap_lam_them_2.service.impl.BikeService;
//
//import java.util.Scanner;
//
//public class BikeController {
//    public void menuManagementBike() {
//        Scanner scanner = new Scanner(System.in);
//        IBikeService bikeService = new BikeService();
//        while (true) {
//            System.out.println("--------------------------------");
//            System.out.println("Quản lí xe ô tô");
//            System.out.println("1. Thêm mới phương tiện ");
//            System.out.println("2. Hiển thị phương tiện");
//            System.out.println("3. Xóa phương tiện");
//            System.out.println("4. Tìm kiếm theo biển kiểm soát");
//            System.out.println("5. Thoát");
//            System.out.println("Mời bạn nhập chức năng");
//            int choice = Integer.parseInt(scanner.nextLine());
//            switch (choice) {
//                case 1:
//                    bikeService.addBike();
//                    break;
//                case 2:
//                    bikeService.displayBike();
//                    break;
//                case 3:
//                    bikeService.deleteBike();
//                    break;
//                case 4:
//                    bikeService.findBike();
//                    break;
//                case 5:
//                    return;
//                default:
//                    System.out.println("Lựa chọn không đúng nhập lại");
//            }
//        }
//    }
//
//}
//
