package bai_tap_lam_them_2.service.impl;

import bai_tap_lam_them_2.model.Car;
import bai_tap_lam_them_2.model.Product;
import bai_tap_lam_them_2.model.Vehicle;
import bai_tap_lam_them_2.service.ICarService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarService implements ICarService {
    private static Scanner scanner = new Scanner(System.in);
    public static List<Car> cars = new ArrayList<>();


    static {
        cars.add(new Car("3", new Product("01", "Honda", "Japan"),
                "2020", "Hùng", 15, "xe khách"));
    }

    @Override
    public Car addCar() {
        Car car = this.infoCar();
        cars.add(car);
        System.out.println("Thêm mới xe ô tô thành công");
        return car;
    }

    @Override
    public void displayCar() {
        List<Car> foundVehicles = new ArrayList<>(cars);
        if (foundVehicles.isEmpty()) {
            System.out.println("Không có xe ô tô trong list");
        } else {
            for (Car car : foundVehicles
            ) {
                System.out.println(car);
            }
        }
    }

    @Override
    public void deleteCar(String licensePlates) {
        Car car = this.searchCar(licensePlates);
        if (car != null) {
            cars.remove(car);
        }
    }

    private Car searchCar(String licensePlates) {
        for (Car car : cars) {
            if (car.getLicensePlates().equals(licensePlates)) {
                return car;
            }
        }
        return null;
    }

    public Car infoCar() {
        String licensePlates;
        do {
            System.out.println("Nhập biển kiếm soát");
            licensePlates = scanner.nextLine();
            boolean isCheck = true;
            for (Car car : cars) {
                if (car.getLicensePlates().equals(licensePlates)) {
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
        System.out.println("Nhập vào kiểu xe");
        String model = scanner.nextLine();
        System.out.println("Nhập vào số chỗ ngồi");
        int seats = Integer.parseInt(scanner.nextLine());
        Car car = new Car(licensePlates, company, manufacture, owner, seats, model);
        return car;
    }
}
