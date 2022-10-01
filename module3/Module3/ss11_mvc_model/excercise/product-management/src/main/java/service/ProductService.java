package service;

import model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService implements IProductService {
    private static List<Product> products = new ArrayList<>();

    static {
        products.add(new Product(1, "Aquarius", "Oke", 150000));
        products.add(new Product(2, "Sting", "Cũng được", 50000));
        products.add(new Product(3, "Bò Húc", "Ngon", 550000));
        products.add(new Product(4, "7up", "Sảng khoái", 1000000));
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
    public void update(int index ,Product product) {
        products.set(index, product);
    }

    @Override
    public void remove(Product product) {
        products.remove(product);
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> findList = new ArrayList<>();
        for (Product product : products) {
            if (product.getName().contains(name)) {
                findList.add(product);
            }
        }
        return findList;
    }
}
