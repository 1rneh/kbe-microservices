package com.henri.kbe.adapter.data;


import org.springframework.data.mongodb.repository.MongoRepository;
import com.henri.kbe.domain.model.DeliveryInfo;

import java.util.Optional;

public interface DeliveryInfoRepository extends MongoRepository<DeliveryInfo, String> {

    Optional<DeliveryInfo> findByName(String name);

    boolean existsByName(String name);
}
