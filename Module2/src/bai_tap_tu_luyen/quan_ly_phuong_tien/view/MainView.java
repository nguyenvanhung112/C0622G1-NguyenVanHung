package bai_tap_tu_luyen.quan_ly_phuong_tien.view;

import bai_tap_tu_luyen.quan_ly_phuong_tien.controller.MainController;

public class MainView {
    public static void main(String[] args) {
        MainController mainController = new MainController();
        mainController.quanLyAll();
    }
}
