package com.ijse.supermarket.service.impl;

import com.ijse.supermarket.dto.ProductDto;
import com.ijse.supermarket.entity.CategoryEntity;
import com.ijse.supermarket.entity.ProductEntity;
import com.ijse.supermarket.repository.CategoryRepository;
import com.ijse.supermarket.repository.ProductRepository;
import com.ijse.supermarket.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public List<ProductEntity> getAllProduction() {
        return productRepository.findAll();
    }

    @Override
    public ProductEntity findProductionById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public ProductEntity createProduction(ProductDto productDto) {
        CategoryEntity category = categoryRepository.findById(productDto.getCategoryId()).orElse(null);

        if (category != null){
            ProductEntity productEntity = new ProductEntity();
            productEntity.setName(productDto.getName());
            productEntity.setPrice(productDto.getPrice());
            productEntity.setQty(productDto.getQty());
            productEntity.setCategoryEntity(category);
            return productRepository.save(productEntity);

        }else {
            return null;
        }
    }

    @Override
    public ProductEntity updateProduction(Long id, ProductDto productDto) {
     ProductEntity productEntity = productRepository.findById(id).orElse(null);
     if (productEntity != null){
        CategoryEntity categoryEntity = categoryRepository.findById(productDto.getCategoryId()).orElse(null);
        if (categoryEntity != null){

            productEntity.setName(productDto.getName());
            productEntity.setPrice(productDto.getPrice());
            productEntity.setQty(productDto.getQty());
            productEntity.setCategoryEntity(categoryEntity);
            return productRepository.save(productEntity);
        }else {
            return null;
        }


     }else {
         return null;
     }
    }

    @Override
    public List<ProductEntity> getProductByCategory(Long id) {
        CategoryEntity category = categoryRepository.findById(id).orElse(null);
        if (category != null){
            return productRepository.findProductByCategory(category);
        }else {
            return null;
        }
    }
}
