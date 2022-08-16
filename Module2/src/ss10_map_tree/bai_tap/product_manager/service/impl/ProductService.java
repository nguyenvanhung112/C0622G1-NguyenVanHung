package ss10_map_tree.bai_tap.product_manager.service.impl;

import ss10_map_tree.bai_tap.product_manager.model.Product;
import ss10_map_tree.bai_tap.product_manager.service.IProduct;

import java.util.*;

public class ProductService implements IProduct {
    public static Scanner scanner = new Scanner(System.in);
    //    public static List<Product> products = new ArrayList<>();
    public static List<Product> products = new LinkedList<>();

    static {
        products.add(new Product("1", "Hoàng", 15000));
        products.add(new Product("2", "Hùng", 45000));
        products.add(new Product("3", "Đạt", 35000));
        products.add(new Product("4", "Uy", 25000));
    }

    @Override
    public void add() {
        Product product = this.info();
        products.add(product);
        System.out.println("Thêm mới thành công");
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
        System.out.println("Nhập giá sản phẩm");
        int price = Integer.parseInt(scanner.nextLine());
        Product product = new Product(id, name, price);
        return product;
    }

    @Override
    public void update() {
        Product product = this.searchId();
        if (product == null) {
            System.out.println("Không tìm thấy sản phẩm");
        } else {
            String id;
            do {
                System.out.println("Nhập mã sản phẩm muốn đổi");
                id = scanner.nextLine();
                boolean isCheck = true;
                for (Product product1 : products) {
                    if (product1.getId().equals(id)) {
                        System.out.println("Mã sản phẩm bị trùng mời bạn nhập lại");
                        isCheck = false;
                        break;
                    }
                    product.setId(id);
                }
                if (isCheck) break;
            } while (true);
            System.out.println("Nhập tên sản phẩm muốn đổi");
            String name = scanner.nextLine();
            product.setName(name);
            System.out.println("Nhập giá sản phẩm muốn đổi");
            int price = Integer.parseInt(scanner.nextLine());
            product.setPrice(price);
            System.out.println("Sửa thành công");
        }
    }

    @Override
    public void delete() {
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
    public void display() {
        System.out.println("Hiển thị sản phẩm");
        System.out.println("1. Hiển thị theo thứ tự tăng dần");
        System.out.println("2. Hiện thị theo thứ tự giảm dần");
        System.out.println("3. Thoát");
        int choice = Integer.parseInt(scanner.nextLine());
        while (true) {
            switch (choice) {
                case 1:
                    Collections.sort(products, new Comparator<Product>()
                     {
                        @Override
                        public int compare(Product o1, Product o2) {
                            return o1.getPrice() > o2.getPrice() ? 1 : -1;
                        }
                    });
                    for (Product product : products){
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
    public void find() {
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

