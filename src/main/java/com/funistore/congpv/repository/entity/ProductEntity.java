package com.funistore.congpv.repository.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
@Getter
@Setter
public class ProductEntity extends BaseEntity{
    @Id
    private int id;
    private String name;
    private Double price;
}
