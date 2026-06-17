package com.northwind.northwind_api.repository;

import com.northwind.northwind_api.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT p FROM Product p LEFT JOIN FETCH p.category")
    List<Product> findAllWithCategories();
    List<Product> findByCategoryId(Long categoryId);
    List<Product> findByProductNameContainingIgnoreCase(String name);
}
