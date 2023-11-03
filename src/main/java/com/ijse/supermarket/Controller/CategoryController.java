package com.ijse.supermarket.Controller;

import com.ijse.supermarket.entity.CategoryEntity;
import com.ijse.supermarket.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class CategoryController {


    @Autowired
    private CategoryService categoryService;

    @PostMapping("/categories")
    public ResponseEntity<?> createCategory(@RequestBody CategoryEntity  categoryEntity){
        try {
            return ResponseEntity.ok().body(categoryService.createCategory(categoryEntity));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Failed to created Product");
        }
    }

    @GetMapping("/categories")
    public ResponseEntity<List<CategoryEntity>> getAllCategory(){
        return ResponseEntity.ok().body(categoryService.getAllCategories());
    }
}
