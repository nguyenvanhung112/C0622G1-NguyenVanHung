package case_study.service;

import java.io.IOException;
import java.text.ParseException;

public interface IBookingService {
    void addNewBooking() throws IOException, ParseException;

    void displayListBooking() throws IOException, ParseException;

}
