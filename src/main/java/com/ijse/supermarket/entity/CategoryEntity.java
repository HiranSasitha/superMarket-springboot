package com.ijse.supermarket.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "category")

public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}
