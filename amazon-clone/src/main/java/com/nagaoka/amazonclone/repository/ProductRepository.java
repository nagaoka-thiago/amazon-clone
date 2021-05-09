package com.nagaoka.amazonclone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nagaoka.amazonclone.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
}
