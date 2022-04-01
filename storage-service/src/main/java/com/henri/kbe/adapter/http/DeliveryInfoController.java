package com.henri.kbe.adapter.http;

import com.henri.kbe.domain.dto.DeliveryInfosDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.henri.kbe.domain.DeliveryInfoService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("rest/delivery-infos")
public class DeliveryInfoController {

    private final DeliveryInfoService deliveryInfoService;

    @GetMapping
    public List<DeliveryInfosDto> getDeliveryInfos() {
        return deliveryInfoService.getDeliveryInfos();
    }

    @GetMapping("{infoName}")
    public DeliveryInfosDto getDeliveryInfoByName(
            @PathVariable String infoName
    ) {
        return deliveryInfoService.findInfoByName(infoName);
    }

}