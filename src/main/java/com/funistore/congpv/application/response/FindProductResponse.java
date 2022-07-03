package com.funistore.congpv.application.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.funistore.congpv.core.domain.Product;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FindProductResponse extends BaseResponse{
    private Product product;
}
