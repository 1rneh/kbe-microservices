package com.henri.kbe.domain;

import com.henri.kbe.adapter.data.DeliveryInfoRepository;
import com.henri.kbe.domain.dto.DeliveryInfosDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class DeliveryInfoService {

    private final DeliveryInfoRepository deliveryInfoRepository;
    //private final DeliveryInfoMapper deliveryInfoMapper;

    public List<DeliveryInfosDto> getDeliveryInfos() {
        return deliveryInfoRepository
                .findAll()
                .stream()
                .map(info -> new DeliveryInfosDto(
                        info.getDeliveryTime(),
                        info.getLocation(),
                        info.getAmount()))
                .collect(Collectors.toList());
    }

    public DeliveryInfosDto findInfoByName(String infoName) {
        return deliveryInfoRepository
                .findByName(infoName)
                .map(info -> new DeliveryInfosDto(
                                info.getDeliveryTime(),
                                info.getLocation(),
                                info.getAmount()))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Info name doesn't exist"));


/*
        return deliveryInfoRepository
                .findByName(infoName)
                .map(info -> deliveryInfoMapper.toDto(info))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Info name doesn't exist"));


 */
    }
}
