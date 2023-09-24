package com.courses.study.springsecurity.service;

import com.courses.study.springsecurity.dto.SaveProduct;
import com.courses.study.springsecurity.persistence.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface ProductService {
    Page<Product> findAllProducts(Pageable pageable);
    Optional<Product> findOneById(Integer productId);
    Product createProduct(SaveProduct product);
    Product updateProduct(Integer productId, SaveProduct product);
    Product disableProductById(Integer productId);
}
