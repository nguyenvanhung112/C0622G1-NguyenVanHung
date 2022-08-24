package ss15_binary_file_serialization.bai_tap.product_manager.service;

import java.io.IOException;

public interface IProduct {
    void add() throws IOException;

    void update() throws IOException;

    void delete() throws IOException;

    void display() throws IOException;

    void find() throws IOException;
}
