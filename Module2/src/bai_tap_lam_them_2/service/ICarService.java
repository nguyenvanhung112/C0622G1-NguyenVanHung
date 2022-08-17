package bai_tap_lam_them_2.service;

import bai_tap_lam_them_2.model.Car;

public interface ICarService {

    Car addCar();

    void displayCar();

    void deleteCar(String li);
}
