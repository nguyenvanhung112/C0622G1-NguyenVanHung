package bai_tap_lam_them_2.service;

import bai_tap_lam_them_2.model.Truck;

public interface ITruckService {
   Truck addTruck();

    void displayTruck();

    void deleteTruck(String licensePlates);
}
