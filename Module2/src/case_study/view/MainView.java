package case_study.view;

import case_study.controller.FuramaController;

import java.io.IOException;
import java.text.ParseException;

public class MainView {
    public static void main(String[] args) throws IOException, ParseException {
        FuramaController furamaController = new FuramaController();
        furamaController.displayMainMenu();
    }
}
