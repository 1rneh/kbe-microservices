package com.henri.kbe.adapter.data;

import com.henri.kbe.domain.model.ProductDetails;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<ProductDetails, String> {
}
