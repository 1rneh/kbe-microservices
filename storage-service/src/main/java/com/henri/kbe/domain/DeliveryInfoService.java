package com.henri.kbe.domain;

import com.henri.kbe.adapter.data.DeliveryInfoRepository;
import com.henri.kbe.domain.dto.DeliveryInfosDto;
import com.henri.kbe.domain.model.DeliveryInfo;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Time;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class DeliveryInfoService {

    private final DeliveryInfoRepository deliveryInfoRepository;

    public List<DeliveryInfosDto> getDeliveryInfos() {
        return deliveryInfoRepository
                .findAll()
                .stream()
                .map(info -> deliveryInfoToDto(info))
                .collect(Collectors.toList());
    }

    public DeliveryInfosDto findInfoByName(String infoName) {
        return deliveryInfoRepository
                .findByName(infoName)
                .map(info -> deliveryInfoToDto(info))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Info name doesn't exist"));

    }

    private DeliveryInfosDto deliveryInfoToDto(DeliveryInfo info) {
        return new DeliveryInfosDto(
                info.getId(),
                info.getName(),
                new Time(info.getDeliveryTime()),
                info.getLocation(),
                info.getAmount());
    }
}
