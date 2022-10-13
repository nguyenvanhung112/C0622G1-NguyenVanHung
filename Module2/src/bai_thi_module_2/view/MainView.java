package bai_thi_module_2.view;

import bai_thi_module_2.controller.CustomerController;

import java.io.IOException;
import java.text.ParseException;

public class MainView {
    public static void main(String[] args) throws IOException, ParseException {
        CustomerController customerController = new CustomerController();
        customerController.displayMainMenu();
    }
}
