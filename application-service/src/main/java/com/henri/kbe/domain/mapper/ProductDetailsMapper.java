package com.henri.kbe.domain.mapper;

import com.henri.kbe.domain.dto.DeliveryInfoDto;
import com.henri.kbe.domain.dto.ProductDetailsDto;
import com.henri.kbe.domain.dto.TaxDto;
import com.henri.kbe.domain.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductDetailsMapper {

    default ProductDetailsDto toDto(Product product, DeliveryInfoDto deliveryInfoDto, TaxDto taxDto) {
        return new ProductDetailsDto(
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                taxDto.tax(),
                product.isEdible(),
                product.getOrigin(),
                product.getDeliveryDate(),
                deliveryInfoDto.deliveryTime(),
                deliveryInfoDto.amount(),
                deliveryInfoDto.location());
    }

}
