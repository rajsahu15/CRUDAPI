package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.getAll();
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable int id) {
        return productRepository.getById(id);
    }

    @PostMapping
    public String addProduct(@RequestBody Product product) {
        productRepository.save(product);
        return "Product added successfully!";
    }

    @PutMapping("/{id}")
    public String updateProduct(@PathVariable int id, @RequestBody Product product) {
        productRepository.update(id, product);
        return "Product updated successfully!";
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable int id) {
        productRepository.delete(id);
        return "Product deleted successfully!";
    }
}