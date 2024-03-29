package com.ijse.supermarket.service.impl;

import com.ijse.supermarket.entity.CategoryEntity;
import com.ijse.supermarket.repository.CategoryRepository;
import com.ijse.supermarket.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public List<CategoryEntity> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public CategoryEntity findCategoryById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public CategoryEntity createCategory(CategoryEntity categoryEntity) {
        return categoryRepository.save(categoryEntity);
    }

    @Override
    public CategoryEntity updateCategory(Long id, CategoryEntity categoryEntity) {
       CategoryEntity category = categoryRepository.findById(id).orElse(null);

       if (category != null){
           category.setName(categoryEntity.getName());
           return categoryRepository.save(category);
       }else {
           return null;
       }
    }

}
