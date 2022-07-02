package com.funistore.congpv.application;

import com.funistore.congpv.application.request.NewProductRequest;
import com.funistore.congpv.application.response.NewProductResponse;
import com.funistore.congpv.core.domain.Product;
import com.funistore.congpv.core.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

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
    public Product getProductDetails(@PathVariable Long id){
        return productService.loadProductDetails(id);
    }

}
