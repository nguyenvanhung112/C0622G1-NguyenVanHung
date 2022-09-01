package case_study.service;

import java.io.IOException;
import java.text.ParseException;

public interface IPromotionService {
    void displayListCustomersGetVoucher() throws IOException, ParseException;

    void displayListCustomersUseService() throws IOException, ParseException;
}
