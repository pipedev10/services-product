package com.example.product.servicesproduct.controller;

import com.example.product.servicesproduct.persistence.entity.Product;
import com.example.product.servicesproduct.service.ProductService;
import java.util.List;
import org.apache.http.HttpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

  @Autowired
  private ProductService productService;

  @GetMapping("/all")
  public ResponseEntity<List<Product>> getAll(){
    return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
  }

  @PostMapping("/save")
  public ResponseEntity<Product> save(@RequestBody Product product){
    return new ResponseEntity<>(productService.save(product), HttpStatus.CREATED);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Product> getProduct(@PathVariable("id") int productId){
    return productService.getProduct(productId).map(product -> new ResponseEntity<>(product, HttpStatus.OK))
        .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity delete(@PathVariable("id") int productId){
    if(productService.delete(productId)){
      return new ResponseEntity(HttpStatus.OK);
    }else{
      return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
  }

  @PutMapping("/update/{id}")
  public ResponseEntity<Product> update(@PathVariable("id") int productId, @RequestBody Product product) {
    product.setProductId(productId);
    return ResponseEntity.ok(productService.update(productId, product));
  }



}
