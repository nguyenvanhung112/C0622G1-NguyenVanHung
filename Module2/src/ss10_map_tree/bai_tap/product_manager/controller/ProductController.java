package ss10_map_tree.bai_tap.product_manager.controller;

import ss10_map_tree.bai_tap.product_manager.service.IProduct;
import ss10_map_tree.bai_tap.product_manager.service.impl.ProductService;

import java.util.Scanner;

public class ProductController {
    Scanner scanner = new Scanner(System.in);
    IProduct productService = new ProductService();

    public void productManagement() {
        while (true) {
            System.out.println("-----------------------------------");
            System.out.println("Quản lí sản phẩm");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Sửa thông tin sản phẩm");
            System.out.println("3. Xóa sản phẩm");
            System.out.println("4. Hiển thị sản phẩm");
            System.out.println("5. Tìm kiếm sản phẩm");
            System.out.println("6. Thoát");
            System.out.println("Chọn chức năng");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    productService.add();
                    break;
                case 2:
                    productService.update();
                    break;
                case 3:
                    productService.delete();
                    break;
                case 4:
                    productService.display();
                    break;
                case 5:
                    productService.find();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Nhập lại chức năng");
            }
        }
    }
}
