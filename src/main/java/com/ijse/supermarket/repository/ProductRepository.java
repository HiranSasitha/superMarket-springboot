package com.ijse.supermarket.repository;

import com.ijse.supermarket.entity.CategoryEntity;
import com.ijse.supermarket.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface ProductRepository extends JpaRepository<ProductEntity,Long> {

    // custom query for get product by category
    @Query("SELECT p from ProductEntity p WHERE p.categoryEntity =:categoryEntity")
    List<ProductEntity> findProductByCategory(@Param("categoryEntity") CategoryEntity categoryEntity);

}
