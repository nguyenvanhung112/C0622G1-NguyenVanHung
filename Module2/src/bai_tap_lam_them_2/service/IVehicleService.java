package bai_tap_lam_them_2.service;

import bai_tap_lam_them_2.model.Vehicle;

import java.util.List;

public interface IVehicleService {

    void findVehicle();

    void deleteVehicle(String licensePlates);

    List<Vehicle> searchVehicle(String licensePlates);

    void addVehicle(Vehicle vehicle);

}
