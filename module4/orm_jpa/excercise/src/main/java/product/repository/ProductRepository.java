package product.repository;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import product.model.Product;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Repository
public class ProductRepository implements IProductRepository {
    private static List<Product> products = new ArrayList<>();


    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> findAll() {
        TypedQuery<Product> query = entityManager
                .createQuery("select p from Product as p", Product.class);
        return query.getResultList();
    }

    @Override
    public void save(Product product) {
        entityManager.persist(product);
    }

    @Override
    public Product findById(int id) {
        return entityManager.find(Product.class, id);
    }

    @Override
    public void update(Product product) {
        entityManager.merge(product);
    }

    @Override
    public void remove(Product product) {
        entityManager.remove(entityManager.merge(product));
    }

    @Override
    public List<Product> getListByName(String name) {
        TypedQuery<Product> query = entityManager
                .createQuery("select p from Product as p where p.name like :name", Product.class)
                .setParameter("name", "%" + name + "%");
        return query.getResultList();
    }
}
