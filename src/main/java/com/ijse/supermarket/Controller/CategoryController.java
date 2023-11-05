package com.ijse.supermarket.Controller;

import com.ijse.supermarket.entity.CategoryEntity;
import com.ijse.supermarket.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*") 

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
    @GetMapping("/categories/{id}")
    public ResponseEntity<CategoryEntity> getCategoryById(@PathVariable Long id){
        CategoryEntity categoryEntity = categoryService.findCategoryById(id);
        if (categoryEntity != null){
            return ResponseEntity.ok().body(categoryEntity);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/categories/{id}")
    public ResponseEntity<CategoryEntity> updateCategory(@PathVariable Long id,@RequestBody CategoryEntity entity){
       return ResponseEntity.ok().body(categoryService.updateCategory(id,entity));
    }

}
