package com.example.product.servicesproduct.persistence.repository;

import com.example.product.servicesproduct.persistence.entity.Product;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

// JPARepository has sort and another functionalities
public interface ProductCrudRepository extends JpaRepository<Product, Integer> {
  Optional<Product> findByProductId(int productId);
}
