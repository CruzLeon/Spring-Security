package com.courses.study.springsecurity.controller;

import com.courses.study.springsecurity.dto.SaveCategory;
import com.courses.study.springsecurity.persistence.entity.Category;
import com.courses.study.springsecurity.service.CategoryService;
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
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<Page<Category>> findAllCategories(
            Pageable pageable) { //Contiene numero de pag y tamaño de pagina

        Page<Category> categories = categoryService.findAllCategories(pageable);

        if (categories.hasContent()) {
            return ResponseEntity.ok(categories);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{category-id}")
    public ResponseEntity<Category> findOneCategory(@PathVariable("category-id") Integer categoryId) {
        return categoryService.findOneById(categoryId).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());

    }

    @PostMapping
    public ResponseEntity<Category> createOneCategory(@RequestBody @Valid SaveCategory category) {
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.createCategory(category));
    }

    @PutMapping("/{category-id}")
    public ResponseEntity<Category> updateCategoryById(@PathVariable("category-id") Integer categoryId,
                                                       @RequestBody @Valid SaveCategory category) {
        return ResponseEntity.ok(categoryService.updateCategory(categoryId, category));
    }

    @PatchMapping("/{category-id}/disable")
    public ResponseEntity<Category> disableCategoryById(@PathVariable("category-id") Integer categoryId) {
        return ResponseEntity.ok(categoryService.disableCategoryById(categoryId));
    }
}
