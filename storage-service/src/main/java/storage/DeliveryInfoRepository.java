package storage;


import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface DeliveryInfoRepository extends MongoRepository<DeliveryInfo, Integer> {

    Optional<DeliveryInfo> findDeliveryInfoByName(String name);

}
