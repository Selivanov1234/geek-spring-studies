package ru.geekbrains;

import org.springframework.beans.factory.annotation.Autowired;
import ru.geekbrains.product.Product;
import ru.geekbrains.product.ProductRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CartService {

    @Autowired
    private ProductRepository productRepository; //Если даю имя pr, то выдает ошибку при создании новой корзины.
    private Map<Product, Integer> prCart;

    public CartService() {
        this.prCart = new HashMap<>();
    }

    public void addProduct(long id, int count) {
        Product item = getProductId(id);
        prCart.merge(item,count, Integer::sum);
    }

    public void removeProduct(long id, int count) {
        Product item = getProductId(id);
        Integer curr = prCart.get(item);
        if (curr <= count) {
            prCart.remove(item);
        } else {
            prCart.merge(item, -count, Integer::sum);
        }
    }

    public List<Product> getAll() {
        return new ArrayList<>(prCart.keySet()); }

    private Product getProductId(long id) {
        Product product = productRepository.findById(id);
        if (product == null) {
            throw new IllegalArgumentException("No such product in the base.");
        }
        return product;
    }
}
