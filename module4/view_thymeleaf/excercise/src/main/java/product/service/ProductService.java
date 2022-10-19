package product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import product.model.Product;
import product.repository.IProductRepository;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository repoProduct;
    @Override
    public List<Product> findAll() {
        return repoProduct.findAll();
    }

    @Override
    public void save(Product product) {
        repoProduct.save(product);
    }

    @Override
    public Product findById(int id) {
        return repoProduct.findById(id);
    }

    @Override
    public void update(int id, Product product) {
            repoProduct.update(id,product);
    }

    @Override
    public void remove(int id) {
        repoProduct.remove(id);
    }

    @Override
    public List<Product> getListByName(String name) {
        return repoProduct.getListByName(name);
    }
}
