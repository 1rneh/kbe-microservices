package com.henri.kbe.domain.mapper;

import com.henri.kbe.domain.dto.ProductDto;
import com.henri.kbe.domain.model.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDto toDto(Product product);

    Product toDomain(ProductDto productDto);
}
