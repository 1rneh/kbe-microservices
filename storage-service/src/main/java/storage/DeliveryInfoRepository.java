package storage;


import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface DeliveryInfoRepository extends MongoRepository<DeliveryInfo, String> {

    Optional<DeliveryInfo> findDeliveryInfoByName(String name);

}
