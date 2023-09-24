package com.courses.study.springsecurity.service.impl;

import com.courses.study.springsecurity.dto.SaveProduct;
import com.courses.study.springsecurity.exc.EntityNotFoundException;
import com.courses.study.springsecurity.persistence.ProductRepository;
import com.courses.study.springsecurity.persistence.entity.Category;
import com.courses.study.springsecurity.persistence.entity.Product;
import com.courses.study.springsecurity.service.ProductService;
import com.courses.study.springsecurity.service.mapper.EntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImp implements ProductService {

    private final ProductRepository productRepository;
    private final EntityMapper entityMapper;

    @Override
    public Page<Product> findAllProducts(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Optional<Product> findOneById(Integer productId) {
        return productRepository.findById(productId);
    }

    @Override
    public Product createProduct(SaveProduct product) {

        Product entity = entityMapper.mapToEntity(product);
        entity.setStatus(Product.ProductStatus.ENABLED);
        Category category = new Category();
        category.setId(product.getCategoryId());
        entity.setCategory(category);
        return productRepository.save(entity);
    }

    @Override
    public Product updateProduct(Integer productId, SaveProduct product) {
        Product productFromDatabase = productRepository.findById(productId).orElseThrow(() -> new EntityNotFoundException("Product not found"));

        productFromDatabase.setName(product.getName());
        productFromDatabase.setPrice(product.getPrice());
        Category category = new Category();
        category.setId(product.getCategoryId());
        productFromDatabase.setCategory(category);

        return productRepository.save(productFromDatabase);
    }

    @Override
    public Product disableProductById(Integer productId) {

        Product productFromDatabase = productRepository.findById(productId).orElseThrow(() -> new EntityNotFoundException("Product not found"));
        productFromDatabase.setStatus(Product.ProductStatus.DISABLED);
        return productRepository.save(productFromDatabase);
    }
}
