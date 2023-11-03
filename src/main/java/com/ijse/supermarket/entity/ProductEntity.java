package com.ijse.supermarket.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "product")

public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private Integer qty;
    private Double price;

    @ManyToOne
    @JoinColumn(name = "category_id" ,nullable = false)
    private  CategoryEntity categoryEntity;

}
