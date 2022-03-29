package storage;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class DeliveryInfoService {

    private final DeliveryInfoRepository deliveryInfoRepository;

    public DeliveryInfo findInfo(String infoId) throws IllegalStateException {

        Optional<DeliveryInfo> infoOptional =
                deliveryInfoRepository.findById(infoId);

        return infoOptional
                .orElseThrow(() -> new IllegalStateException("info not found."));
    }

    public void addNewDeliveryInfo(DeliveryAddingRequest request) {

        DeliveryInfo deliveryInfo = new DeliveryInfo(
                request.name(),
                new Date(),
                request.amount(),
                request.location());

        deliveryInfoRepository.save(deliveryInfo);
    }

    public List<DeliveryInfo> getDeliveryInfos() {
        return deliveryInfoRepository.findAll();
    }
}
