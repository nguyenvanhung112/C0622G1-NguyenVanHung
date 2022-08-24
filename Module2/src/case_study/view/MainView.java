package case_study.view;

import case_study.controller.FuramaController;

import java.io.IOException;

public class MainView {
    public static void main(String[] args) throws IOException {
        FuramaController furamaController = new FuramaController();
        furamaController.displayMainMenu();
    }
}
