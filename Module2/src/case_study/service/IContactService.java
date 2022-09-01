package case_study.service;

import java.io.IOException;
import java.text.ParseException;

public interface IContactService {
    void creatNewContracts() throws IOException, ParseException;

    void displayListContracts() throws IOException, ParseException;

    void editContracts() throws IOException, ParseException;
}
