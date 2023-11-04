package com.ijse.supermarket.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class ProductDto {
    private String name;
    private Double price;
    private Integer qty;
    private Long categoryId;
}
