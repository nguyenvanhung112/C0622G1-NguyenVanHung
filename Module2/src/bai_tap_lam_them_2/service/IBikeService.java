package bai_tap_lam_them_2.service;

import bai_tap_lam_them_2.model.Bike;

public interface IBikeService {

   Bike addBike();

   void displayBike();

   void deleteBike(String licensePlates);
}
