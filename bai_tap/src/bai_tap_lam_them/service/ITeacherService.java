package bai_tap_lam_them.service;

import java.io.IOException;

public interface ITeacherService {
    void displayAllTeacher() throws IOException;

    void addTeacher() throws IOException;

    void removeTeacher() throws IOException;

    void searchTeacher() throws IOException;
}
