package ss15_binary_file_serialization.bai_tap.product_manager.view;

import ss15_binary_file_serialization.bai_tap.product_manager.controller.ProductController;


import java.io.IOException;


public class MainView {
    public static void main(String[] args) throws IOException {
        ProductController productController = new ProductController();
        productController.productManagement();
    }
}
