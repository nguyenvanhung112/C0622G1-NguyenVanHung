package bai_tap_lam_them.service;

import java.io.IOException;

public interface IStudentService {

    void addStudent() throws IOException;

    void displayAllStudent() throws IOException;

    void removeStudent() throws IOException;

    void searchStudent() throws IOException;
}
