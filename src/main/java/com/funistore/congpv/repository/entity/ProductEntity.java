package com.funistore.congpv.repository.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
@Getter
@Setter
public class ProductEntity {
    @Id
    private int id;
    private String name;
    private String description;
    private Double price;
    private int quantity;
    private int category_id;
    private int brand_id;
    private int image_id;
    private int status;
    private int user_id;
}
