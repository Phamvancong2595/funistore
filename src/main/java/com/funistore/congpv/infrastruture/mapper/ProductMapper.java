package com.funistore.congpv.infrastruture.mapper;

import com.funistore.congpv.core.domain.Product;
import com.funistore.congpv.repository.entity.ProductEntity;
import com.funistore.congpv.repository.vo.ProductDetailVO;
import org.springframework.stereotype.Component;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
@Mapper(componentModel = "spring")
@Component
public interface ProductMapper {

    //@Mappings({})
    ProductEntity toEntity(Product product);

    //@Mappings({})
    Product toModel(ProductEntity entity);

    Product toModelV2(ProductDetailVO vo);
}
