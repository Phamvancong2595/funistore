package com.funistore.congpv.application.controller;

import com.funistore.congpv.application.request.NewProductRequest;
import com.funistore.congpv.application.response.FindProductResponse;
import com.funistore.congpv.application.response.NewProductResponse;
import com.funistore.congpv.core.domain.Product;
import com.funistore.congpv.core.service.ProductService;
import com.funistore.congpv.infrastruture.exception.ProductNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/products")
@RequiredArgsConstructor
public class ProductController extends BaseController{
    private final ProductService productService;
    @PostMapping(
            value = "/add",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public NewProductResponse addNewProduct(@RequestBody NewProductRequest request){
       productService.insertNewProduct(request);
        return new NewProductResponse("ok");
    }
    @GetMapping(value = "/get_details/{id}")
    public FindProductResponse getProductDetails(@PathVariable Long id) throws ProductNotFoundException {
        return FindProductResponse.builder()
                .product(productService.loadProductDetails(id))
                .status(true)
                .build();
    }

}
