package com.funistore.congpv.repository.read_only;

import com.funistore.congpv.repository.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface RoProductRepository extends JpaRepository<ProductEntity,Long> {
}
