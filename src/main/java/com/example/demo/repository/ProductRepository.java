package com.example.demo.repository;

import com.example.demo.model.Product;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class ProductRepository {
    private Map<Integer, Product> productMap = new HashMap<>();

    public List<Product> getAll() {
        return new ArrayList<>(productMap.values());
    }

    public Product getById(int id) {
        return productMap.get(id);
    }

    public void save(Product product) {
        productMap.put(product.getId(), product);
    }

    public void update(int id, Product product) {
        productMap.put(id, product);
    }

    public void delete(int id) {
        productMap.remove(id);
    }
}