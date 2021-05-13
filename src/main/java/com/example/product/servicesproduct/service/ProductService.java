package com.example.product.servicesproduct.service;

import com.example.product.servicesproduct.persistence.entity.Product;
import java.util.List;
import java.util.Optional;

public interface ProductService {
  public List<Product> getAll();
  public Product save(Product product);
  public Optional<Product> getProduct(int productId);
  public Boolean delete(int productId);
  public Product update(int productId, Product product);
}
