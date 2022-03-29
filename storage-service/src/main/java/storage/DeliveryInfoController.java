package storage;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("rest/delivery-infos")
public class DeliveryInfoController {

    private final DeliveryInfoService deliveryInfoService;
/*
    @GetMapping("{infoId}")
    public DeliveryInfoResponse getDeliveryInfoById(
            @PathVariable("infoId") String infoId
    ) {
        DeliveryInfo infoFound = deliveryInfoService.findInfoById(infoId);
        return new DeliveryInfoResponse(infoFound);
    }

 */

    @GetMapping("{infoName}")
    public DeliveryInfoResponse getDeliveryInfoByName(
            @PathVariable("infoName") String infoName
    ) {
        DeliveryInfo infoFound = deliveryInfoService.findInfoByName(infoName);
        return new DeliveryInfoResponse(infoFound);
    }

    @GetMapping
    public List<DeliveryInfo> getDeliveryInfos() {
        return deliveryInfoService.getDeliveryInfos();
    }

    @PostMapping
    public void addDeliveryInfo(@RequestBody DeliveryAddingRequest deliveryAddingRequest) {
        deliveryInfoService.addNewDeliveryInfo(deliveryAddingRequest);
        log.info("added delivery info: {}", deliveryAddingRequest);
    }
}