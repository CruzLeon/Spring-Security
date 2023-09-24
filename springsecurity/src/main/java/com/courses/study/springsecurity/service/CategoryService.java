package com.courses.study.springsecurity.service;

import com.courses.study.springsecurity.dto.SaveCategory;
import com.courses.study.springsecurity.dto.SaveProduct;
import com.courses.study.springsecurity.persistence.entity.Category;
import com.courses.study.springsecurity.persistence.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Range;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface CategoryService {

    Page<Category> findAllCategories(Pageable pageable);

    Optional<Category> findOneById(Integer categoryId);

    Category createCategory(SaveCategory category);

    Category updateCategory(Integer categoryId, SaveCategory category);

    Category disableCategoryById(Integer categoryId);
}
