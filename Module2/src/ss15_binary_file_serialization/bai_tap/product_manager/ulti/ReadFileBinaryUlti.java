package ss15_binary_file_serialization.bai_tap.product_manager.ulti;

import ss15_binary_file_serialization.bai_tap.product_manager.model.Product;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class ReadFileBinaryUlti {
    public static List<Product> readDataFromFile(String path) throws IOException {
        List<Product> products = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            products = (List<Product>) ois.readObject();
            fis.close();
            ois.close();
        } catch (Exception ex) {
            System.out.println("Không có sản phẩm nào trong list, Bạn thêm sản phẩm vào đi !");
        }
        return products;
    }
}
