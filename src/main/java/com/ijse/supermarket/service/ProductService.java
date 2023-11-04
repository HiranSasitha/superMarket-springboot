package com.ijse.supermarket.service;

import com.ijse.supermarket.dto.ProductDto;
import com.ijse.supermarket.entity.ProductEntity;

import java.util.List;

public interface ProductService {
    List<ProductEntity> getAllProduction();
    ProductEntity findProductionById(Long id);
    ProductEntity createProduction(ProductDto productDto);
    ProductEntity updateProduction(Long id,ProductDto productDto);
    List<ProductEntity> getProductByCategory(Long id);
}
