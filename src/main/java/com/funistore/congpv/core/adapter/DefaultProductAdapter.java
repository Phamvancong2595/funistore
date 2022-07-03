package com.funistore.congpv.core.adapter;

import com.funistore.congpv.core.domain.Product;
import com.funistore.congpv.infrastruture.config.CacheConfig;
import com.funistore.congpv.infrastruture.mapper.ProductMapper;
import com.funistore.congpv.repository.primary.ProductRepository;
import com.funistore.congpv.repository.read_only.RoProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component("DefaultProductAdapter")
@RequiredArgsConstructor
public class DefaultProductAdapter implements ProductAdapter{
    private final ProductRepository productRepository;
    private final RoProductRepository roProductRepository;
    private final ProductMapper productMapper;
    @Override
    public List<Product> loadAllProducts() {
        return roProductRepository.findAll().stream().map(productMapper::toModel).collect(Collectors.toList());
    }

    @Override
    public void insertNewProduct(Product product) {
        this.productRepository.save(this.productMapper.toEntity(product));
    }

    @Override
    @Cacheable(
            cacheNames = "productDetails",
            unless = "#result == null",
            cacheManager = CacheConfig.CACHE_REDIS)
    public Product loadProductDetails(Long id) {
        return productMapper.toModelV2(roProductRepository.getProductDetailsById(id));
    }

}
