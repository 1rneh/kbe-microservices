package com.henri.kbe.adapter.data;

import com.henri.kbe.domain.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

    boolean existsByName(String name);
}
