package com.example.product.servicesproduct.service;

import com.example.product.servicesproduct.persistence.entity.Product;
import com.example.product.servicesproduct.persistence.repository.ProductCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ProductServiceImpl implements ProductService{

  @Autowired
  private ProductCrudRepository productCrudRepository;

  @Override
  public List<Product> getAll() {
    return (List<Product>) productCrudRepository.findAll();
  }

  @Override
  public Product save(Product product) {
    //return productCrudRepository.save(product);
    Product productAux = productCrudRepository.save(product);
    productAux.setPrice(null);
    return productAux;
  }

  @Override
  public Optional<Product> getProduct(int productId) {
    return productCrudRepository.findByProductId(productId);
  }

  @Override
  public Boolean delete(int productId) {
    return getProduct(productId).map(product -> {
      productCrudRepository.deleteById(productId);
      return true;
    }).orElse(false);
  }

  @Override
  public Product update(int productId, Product product) {
    //return productCrudRepository.save(product);
    if(!getProduct(productId).isPresent()){
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Product not found");
    }
    Product productAux = productCrudRepository.save(product);
    productAux.setPrice(null);
    return productAux;
  }
}
