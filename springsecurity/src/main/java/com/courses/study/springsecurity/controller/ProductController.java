package com.courses.study.springsecurity.controller;

import com.courses.study.springsecurity.dto.SaveProduct;
import com.courses.study.springsecurity.persistence.entity.Product;
import com.courses.study.springsecurity.service.ProductService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<Page<Product>> findAllProducts(
            Pageable pageable) { //Contiene numero de pag y tamaño de pagina

        Page<Product> products = productService.findAllProducts(pageable);

        if (products.hasContent()) {
            return ResponseEntity.ok(products);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{product-id}")
    public ResponseEntity<Product> findOneProduct(@PathVariable("product-id") Integer productId) {
        return productService.findOneById(productId).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());

    }

    @PostMapping
    public ResponseEntity<Product> createOneProduct(@RequestBody @Valid SaveProduct product) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.createProduct(product));
    }

    @PutMapping("/{product-id}")
    public ResponseEntity<Product> updateProductById(@PathVariable("product-id") Integer productId,
                                                     @RequestBody @Valid SaveProduct product) {
        return ResponseEntity.ok(productService.updateProduct(productId, product));
    }

    @PatchMapping("/{product-id}/disable")
    public ResponseEntity<Product> disableProductById(@PathVariable("product-id") Integer productId) {
        return ResponseEntity.ok(productService.disableProductById(productId));
    }
}
