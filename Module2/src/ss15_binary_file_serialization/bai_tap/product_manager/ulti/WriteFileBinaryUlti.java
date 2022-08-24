package ss15_binary_file_serialization.bai_tap.product_manager.ulti;

import ss15_binary_file_serialization.bai_tap.product_manager.model.Product;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class WriteFileBinaryUlti {
    public static void writeToFile(String path, List<Product> products) throws IOException {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(products);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
