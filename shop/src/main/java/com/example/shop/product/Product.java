package com.example.shop.product;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "products")
@Getter
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    @Column(name = "product_name", length = 50)
    private String name;

    @Column(name = "product_price")
    private int price;

    @Column(name = "product_inventory")
    private int inventory;

    public Product(String name, int price, int inventory) {
        this.name = name;
        this.price = price;
        this.inventory = inventory;
    }


    public void updateInfo(String name, int price, int inventory) {
        if(name != null) {
            this.name = name;
        }

        if(price >= 0) {
            this.price = price;
        }

        if(inventory >= 0) {
            this.inventory = inventory;
        }
    }
}