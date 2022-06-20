package com.funistore.congpv.repository.primary;

import com.funistore.congpv.repository.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ProductRepository extends JpaRepository<ProductEntity,Long> {
}
