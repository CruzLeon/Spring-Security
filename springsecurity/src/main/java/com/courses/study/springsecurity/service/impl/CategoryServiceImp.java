package com.courses.study.springsecurity.service.impl;

import com.courses.study.springsecurity.dto.SaveCategory;
import com.courses.study.springsecurity.exc.EntityNotFoundException;
import com.courses.study.springsecurity.persistence.CategoryRepository;
import com.courses.study.springsecurity.persistence.entity.Category;
import com.courses.study.springsecurity.service.CategoryService;
import com.courses.study.springsecurity.service.mapper.EntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryServiceImp implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private EntityMapper entityMapper;


    @Override
    public Page<Category> findAllCategories(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }

    @Override
    public Optional<Category> findOneById(Integer categoryId) {
        return categoryRepository.findById(categoryId);
    }

    @Override
    public Category createCategory(SaveCategory category) {

        Category entity = entityMapper.mapToEntity(category);
        entity.setStatus(Category.CategoryStatus.ENABLED);
        return categoryRepository.save(entity);
    }

    @Override
    public Category updateCategory(Integer categoryId, SaveCategory category) {
        Category categoryFromDatabase = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new EntityNotFoundException("Category not found"));

        categoryFromDatabase.setName(category.getName());
        return categoryRepository.save(categoryFromDatabase);
    }

    @Override
    public Category disableCategoryById(Integer categoryId) {

        Category categoryFromDatabase = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new EntityNotFoundException("Category not found"));
        categoryFromDatabase.setStatus(Category.CategoryStatus.DISABLED);
        return categoryRepository.save(categoryFromDatabase);
    }

}
