
package ie.atu.cicd1.catalog.repository;

import ie.atu.cicd1.catalog.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("""
        SELECT p
        FROM Product p
        WHERE p.price >= :minPrice
        ORDER BY p.price ASC
        """)
    List<Product> findByMinimumPrice(
            @Param("minPrice") BigDecimal minPrice);
}
