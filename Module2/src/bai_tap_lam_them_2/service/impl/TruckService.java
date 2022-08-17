package bai_tap_lam_them_2.service.impl;

import bai_tap_lam_them_2.model.Car;
import bai_tap_lam_them_2.model.Product;
import bai_tap_lam_them_2.model.Truck;
import bai_tap_lam_them_2.model.Vehicle;
import bai_tap_lam_them_2.service.ITruckService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TruckService implements ITruckService {
    private static Scanner scanner = new Scanner(System.in);
    public static List<Truck> trucks = new ArrayList<>();

    static {
        trucks.add(new Truck("2", new Product("02", "Yamaha", "Japan"),
                "2020", "Hoàng", 1500));
    }

    @Override
    public Truck addTruck() {
        Truck truck = this.infoTruck();
        trucks.add(truck);
        System.out.println("Thêm mới xe tải thành công");
        return truck;
    }

    public Truck infoTruck() {
        String licensePlates;
        do {
            System.out.println("Nhập biển kiếm soát");
            licensePlates = scanner.nextLine();
            boolean isCheck = true;
            for (Truck truck : trucks) {
                if (truck.getLicensePlates().equals(licensePlates)) {
                    System.out.println("Biển kiểm soát bị trùng vui lòng nhập lại");
                    isCheck = false;
                    break;
                }
            }
            if (isCheck) break;
        } while (true);
        System.out.println("Nhập hãng sản xuất");
        System.out.println("Nhập mã hãng");
        String code = scanner.nextLine();
        System.out.println("Nhập tên hãng sản xuất");
        String productName = scanner.nextLine();
        System.out.println("Nhập quốc gia");
        String national = scanner.nextLine();
        Product company = new Product(code, productName, national);
        System.out.println("Nhập vào năm sản xuất");
        String manufacture = scanner.nextLine();
        System.out.println("Nhập vào chủ sỡ hữu");
        String owner = scanner.nextLine();
        System.out.println("Nhập vào trọng tải");
        int tonnage = Integer.parseInt(scanner.nextLine());
        return new Truck(licensePlates, company, manufacture, owner, tonnage);
    }

    @Override
    public void displayTruck() {
        List<Truck> foundVehicles = new ArrayList<>(trucks);
        if (foundVehicles.isEmpty()) {
            System.out.println("Không có xe tải trong list");
        } else {
            for (Truck truck : foundVehicles
            ) {
                System.out.println(truck);
            }
        }
    }

    @Override
    public void deleteTruck(String licensePlates) {
        Truck truck = this.searchTruck(licensePlates);
        if (truck != null) {
            trucks.remove(truck);

        }
    }

    private Truck searchTruck(String licensePlates) {
        for (Truck truck : trucks
        ) {
            if (truck.getLicensePlates().equals(licensePlates)) {
                return truck;
            }
        }
        return null;
    }

}
