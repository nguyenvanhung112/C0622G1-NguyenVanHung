package product.repository;

import org.springframework.stereotype.Service;
import product.model.Product;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductRepository implements IProductRepository {
    private static List<Product> products = new ArrayList<>();

    static {
        products.add(new Product(1, "Tủ Lạnh", "Đen", "Panasonic"));
        products.add(new Product(2, "TV", "Trắng", "Samsung"));
        products.add(new Product(3, "Điều Hòa", "Đen", "Panasonic"));
        products.add(new Product(4, "Máy giặt", "Trắng", "Aqua"));
        products.add(new Product(5, "Điện thoại", "Đen", "Apple"));
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public void save(Product product) {
        products.add(product);
    }

    @Override
    public Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void update(int id, Product product) {
        for (Product item : products) {
            if (item.getId() == id) {
                item.setName(product.getName());
                item.setAttribute(product.getAttribute());
                item.setCompany(product.getCompany());
            }
        }
    }

    @Override
    public void remove(int id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                products.remove(i);
            }
        }
    }

    @Override
    public List<Product> getListByName(String name) {
        List<Product> productList = new ArrayList<>();
        for (Product product : products) {
            if (product.getName().contains(name)) {
                productList.add(product);
            }
        }
        return productList;
    }
}
