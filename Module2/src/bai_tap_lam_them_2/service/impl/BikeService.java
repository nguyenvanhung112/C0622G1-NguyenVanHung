package bai_tap_lam_them_2.service.impl;

import bai_tap_lam_them_2.model.Bike;
import bai_tap_lam_them_2.model.Product;
import bai_tap_lam_them_2.model.Vehicle;
import bai_tap_lam_them_2.service.IBikeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BikeService implements IBikeService {

    private static Scanner scanner = new Scanner(System.in);
    public static List<Bike> bikes = new ArrayList<>();

    static {
        bikes.add(new Bike("1", new Product("01", "Honda", "Japan"),
                "2020", "Hùng", "150"));
    }

    @Override
    public Bike addBike() {
        Bike bike = this.infoBike();
        bikes.add(bike);
        System.out.println("Thêm mới xe máy thành công");
        return bike;
    }

    public Bike infoBike() {
        String licensePlates;
        do {
            System.out.println("Nhập biển kiếm soát");
            licensePlates = scanner.nextLine();
            boolean isCheck = true;
            for (Bike bike : bikes) {
                if (bike.getLicensePlates().equals(licensePlates)) {
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
        System.out.println("Nhập vào công suất");
        String wattage = scanner.nextLine();
        Bike bike = new Bike(licensePlates, company, manufacture, owner, wattage);

        return bike;
    }

    @Override
    public void displayBike() {
        List<Bike> foundVehicles = new ArrayList<>(bikes);
        if (foundVehicles.isEmpty()) {
            System.out.println("Không có xe máy trong list");
        } else {
            for (Bike bike : foundVehicles
            ) {
                System.out.println(bike);
            }

        }
    }

    @Override
    public void deleteBike(String licensePlates) {
        Bike bike = this.searchBike(licensePlates);
        if (bike != null) {
            bikes.remove(bike);
        }
    }

    public Bike searchBike(String licensePlates) {
        for (Bike bike : bikes
        ) {
            if (bike.getLicensePlates().equals(licensePlates)) {
                return bike;
            }
        }
        return null;
    }
}
