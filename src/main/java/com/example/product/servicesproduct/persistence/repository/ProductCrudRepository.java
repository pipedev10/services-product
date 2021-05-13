package com.example.product.servicesproduct.persistence.repository;

import com.example.product.servicesproduct.persistence.entity.Product;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

// JPARepository has sort and another functionalities
public interface ProductCrudRepository extends CrudRepository<Product, Integer> {
  Optional<Product> findByProductId(int productId);
}
