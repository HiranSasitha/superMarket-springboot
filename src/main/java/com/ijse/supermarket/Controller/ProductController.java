package com.ijse.supermarket.Controller;

import com.ijse.supermarket.dto.ProductDto;
import com.ijse.supermarket.entity.ProductEntity;
import com.ijse.supermarket.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/product")
    public ResponseEntity<?> createProduct(@RequestBody ProductDto productDto){
        try {
            return ResponseEntity.ok().body(productService.createProduction(productDto));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Failed to create product");
        }
    }

    @GetMapping("/product")
    public ResponseEntity<List<ProductEntity>> getAllProduct(){
        return ResponseEntity.status(HttpStatus.OK).body(productService.getAllProduction());
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<ProductEntity> getProductById(@PathVariable Long id){
        ProductEntity productEntity = productService.findProductionById(id);

        if(productEntity != null){
            return ResponseEntity.status(HttpStatus.OK).body(productEntity);  //Return 200 ok with body
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);// return 404 not found
        }
    }

    @PutMapping("/product/{id}")
    public ProductEntity updateProduct(@PathVariable Long id,@RequestBody ProductDto productDto){
        return productService.updateProduction(id,productDto);
    }

    @GetMapping("/categories/{id}/products")

    public ResponseEntity<List<ProductEntity>> getProductsByCategory(@PathVariable Long id){
        return ResponseEntity.ok().body(productService.getProductByCategory(id));
    }
}
