package com.northwind.northwind_api.service;

import com.northwind.northwind_api.model.Product;
import com.northwind.northwind_api.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAllWithCategories();
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public List<Product> getProductsByCategoryId(Long categoryId) {
        return productRepository.findByCategoryId(categoryId);
    }

    public List<Product> searchByName(String name) {
        return productRepository.findByProductNameContainingIgnoreCase(name);
    }

    public Optional<Product> updateProduct(Long id, Product product) {
        Optional<Product> row = productRepository.findById(id);
        if (row.isEmpty()) {
            return row;
        }
        product.setId(id);
        return Optional.of(productRepository.save(product));
    }
}
