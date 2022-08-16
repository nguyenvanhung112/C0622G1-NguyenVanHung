package ss10_map_tree.bai_tap.product_manager.view;

import ss10_map_tree.bai_tap.product_manager.controller.ProductController;

public class MainView {
    public static void main(String[] args) {
        ProductController productController = new ProductController();
        productController.productManagement();
    }
}
