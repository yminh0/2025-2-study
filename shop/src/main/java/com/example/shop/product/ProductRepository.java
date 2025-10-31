package com.example.shop.product;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository {

    @PersistenceContext
    private EntityManager em;

    public Product findByName(Long name) {
        return em.find(Product.class, name);
    }

    public Product findAll(Long name) {
        return em.createQuery("SELECT p FROM Product p",Product.class)
                .getResultList();
    }

    public void save(Product product) {
        em.persist(product);
    }

    public void deleteByName(Long name) {
        Product product=em.find(Product.class,name);
        em.remove(product);
    }

}
