//package bai_tap_lam_them_2.controller;
//
//import bai_tap_lam_them_2.service.ITruckService;
//import bai_tap_lam_them_2.service.impl.TruckService;
//
//import java.util.Scanner;
//
//public class TruckController {
//    public void menuManagementTruck() {
//        Scanner scanner = new Scanner(System.in);
//        ITruckService truckService = new TruckService();
//        while (true) {
//            System.out.println("--------------------------------");
//            System.out.println("Quản lí xe tải");
//            System.out.println("1. Thêm mới phương tiện ");
//            System.out.println("2. Hiển thị phương tiện");
//            System.out.println("3. Xóa phương tiện");
//            System.out.println("4. Tìm kiếm theo biển kiểm soát");
//            System.out.println("5. Thoát");
//            System.out.println("Mời bạn nhập chức năng");
//            int choice = Integer.parseInt(scanner.nextLine());
//            switch (choice) {
//                case 1:
//                    truckService.addTruck();
//                    break;
//                case 2:
//                    truckService.displayTruck();
//                    break;
//                case 3:
//                    truckService.deleteTruck();
//                    break;
//                case 4:
//                    truckService.findTruck();
//                    break;
//                case 5:
//                    return;
//                default:
//                    System.out.println("Lựa chọn không đúng nhập lại");
//            }
//        }
//    }
//}
