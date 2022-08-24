package ss15_binary_file_serialization.bai_tap.product_manager.service.impl;

import ss15_binary_file_serialization.bai_tap.product_manager.ulti.ReadFileBinaryUlti;
import ss15_binary_file_serialization.bai_tap.product_manager.ulti.WriteFileBinaryUlti;
import ss15_binary_file_serialization.bai_tap.product_manager.model.Product;
import ss15_binary_file_serialization.bai_tap.product_manager.service.IProduct;

import java.io.IOException;
import java.util.*;

public class ProductService implements IProduct {
    public static Scanner scanner = new Scanner(System.in);
    public static List<Product> products = new ArrayList<>();
    final String PATH_PRODUCT = "src\\ss15_binary_file_serialization\\bai_tap\\product_manager\\data\\products";

    static {
        products.add(new Product("1", "Hoàng", "Aqua", 15000, "Không có gì"));
    }

    @Override
    public void add() throws IOException {
        products = ReadFileBinaryUlti.readDataFromFile(PATH_PRODUCT);
        Product product = this.info();
        products.add(product);
        System.out.println("Thêm mới thành công");
        WriteFileBinaryUlti.writeToFile(PATH_PRODUCT, products);
    }

    private Product info() {
        String id;
        do {
            System.out.println("Nhập mã sản phẩm");
            id = scanner.nextLine();
            boolean isCheck = true;
            for (Product product : products) {
                if (product.getId().equals(id)) {
                    System.out.println("Mã sản phẩm bị trùng mời bạn nhập lại");
                    isCheck = false;
                    break;
                }
            }
            if (isCheck) break;
        } while (true);

        System.out.println("Nhập tên sản phẩm");
        String name = scanner.nextLine();
        System.out.println("Nhập vào hãng sản xuất");
        String manufacturer = scanner.nextLine();
        System.out.println("Nhập giá sản phẩm");
        int price = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập vào mô tả khác");
        String otherDescription = scanner.nextLine();
        Product product = new Product(id, name, manufacturer, price, otherDescription);
        return product;
    }

    @Override
    public void update() throws IOException {
        products = ReadFileBinaryUlti.readDataFromFile(PATH_PRODUCT);
        Product product = this.searchId();
        if (product == null) {
            System.out.println("Không tìm thấy sản phẩm");
        } else {
            int index = products.indexOf(product);
            products.set(index, info());
            System.out.println("Sửa thành công");
        }
        WriteFileBinaryUlti.writeToFile(PATH_PRODUCT, products);

    }

    @Override
    public void delete() throws IOException {
        products = ReadFileBinaryUlti.readDataFromFile(PATH_PRODUCT);
        Product product = this.searchId();
        if (product == null) {
            System.out.println("Không tim thấy sản phẩm");
        } else {
            System.out.println("Bạn có muốn xóa sản phẩm " + "[ID " + product.getId() + " Tên sản phẩm "
                    + product.getName() + " Giá " + product.getPrice() + "] không?");
            System.out.println("1. Có");
            System.out.println("2. Không");
            System.out.println("Nhập lựa chọn");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 1) {
                products.remove(product);
                System.out.println("Xóa thành côngg");
            }
        }
        WriteFileBinaryUlti.writeToFile(PATH_PRODUCT, products);
    }

    private Product searchId() {
        System.out.println("Nhập vào mã sản phẩm muốn tìm");
        String id = scanner.nextLine();
        for (Product product : products) {
            if (product.getId().equals(id)) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void display() throws IOException {
        products = ReadFileBinaryUlti.readDataFromFile(PATH_PRODUCT);
        System.out.println("Hiển thị sản phẩm");
        System.out.println("1. Hiển thị theo thứ tự tăng dần");
        System.out.println("2. Hiện thị theo thứ tự giảm dần");
        System.out.println("3. Thoát");
        int choice = Integer.parseInt(scanner.nextLine());
        while (true) {
            switch (choice) {
                case 1:
                    Collections.sort(products, new Comparator<Product>() {
                        @Override
                        public int compare(Product o1, Product o2) {
                            return o1.getPrice() > o2.getPrice() ? 1 : -1;
                        }
                    });
                    WriteFileBinaryUlti.writeToFile(PATH_PRODUCT, products);

                    for (Product product : products) {
                        System.out.println(product);
                    }

                    return;
                case 2:
                    Collections.sort(products, new Comparator<Product>() {
                        @Override
                        public int compare(Product o1, Product o2) {
                            return o1.getPrice() < o2.getPrice() ? 1 : -1;
                        }

                    });
                    WriteFileBinaryUlti.writeToFile(PATH_PRODUCT, products);
                    for (Product product : products
                    ) {
                        System.out.println(product);
                    }

                    return;
                case 3:
                    return;
                default:
                    System.out.println("Nhập lại lựa chọn");
                    return;
            }
        }
    }

    @Override
    public void find() throws IOException {
        products = ReadFileBinaryUlti.readDataFromFile(PATH_PRODUCT);
        Product product = this.searchName();
        if (product == null) {
            System.out.println("Không có sản phẩm");
        } else {
            System.out.println(product);
        }
    }

    private Product searchName() {
        System.out.println("Nhập vào tên sản phẩm muốn tìm");
        String name = scanner.nextLine();
        for (Product product : products) {
            if (product.getName().equals(name)) {
                return product;
            }
        }
        return null;
    }
}

