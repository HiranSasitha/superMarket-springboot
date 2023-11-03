package com.ijse.supermarket.service;

import com.ijse.supermarket.entity.CategoryEntity;

import java.util.List;

public interface CategoryService {
    List<CategoryEntity> getAllCategories();
    CategoryEntity findCategoryById(Long id);
    CategoryEntity createCategory(CategoryEntity categoryEntity);
    CategoryEntity updateCategory(Long id,CategoryEntity categoryEntity);
}
