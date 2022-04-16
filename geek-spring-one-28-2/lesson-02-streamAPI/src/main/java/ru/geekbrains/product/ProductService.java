package ru.geekbrains.product;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ProductService implements ProductRepository {
    private final Map<Long, Product> productMap = new ConcurrentHashMap<>();
    private final AtomicLong identity = new AtomicLong(0);

@PostConstruct
    public void create() {
        this.insert(new Product(null, "Mango"));
        this.insert(new Product(null, "Oranges"));
        this.insert(new Product(null, "Cabbage"));
        this.insert(new Product(null, "Lemon"));
        this.insert(new Product(null, "Coconut"));
        this.insert(new Product(null, "Salmon"));
        this.insert(new Product(null, "Pear"));
        this.insert(new Product(null, "Tangerines"));
        this.insert(new Product(null, "Clementines"));
        this.insert(new Product(null, "Avocado"));
        this.insert(new Product(null, "Apples"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public Product findById(long id) {
        return productMap.get(id);
    }

    @Override
    public void insert(Product product) {
        if (product.getId() == null) {
            long id = identity.incrementAndGet();
            product.setId(id);
        }
        productMap.put(product.getId(), product);
    }

    @Override
    public void delete(long id) {
        productMap.remove(id);
    }
}
