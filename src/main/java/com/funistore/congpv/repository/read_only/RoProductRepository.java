package com.funistore.congpv.repository.read_only;

import com.funistore.congpv.repository.entity.ProductEntity;
import com.funistore.congpv.repository.vo.ProductDetailVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public interface RoProductRepository extends JpaRepository<ProductEntity,Long> {
@Query(
        value =
                "SELECT \n" +
                        "    p.id,\n" +
                        "    p.name,\n" +
                        "    p.price,\n" +
                        "    pd.description,\n" +
                        "    pd.quantity,\n" +
                        "    pd.image_path\n" +
                        "FROM\n" +
                        "    product p\n" +
                        "        JOIN\n" +
                        "    product_details pd ON p.id = pd.product_id\n" +
                        "WHERE\n" +
                        "    p.id = :id", nativeQuery = true
)
    ProductDetailVO getProductDetailsById(@Param("id") long id);
}
