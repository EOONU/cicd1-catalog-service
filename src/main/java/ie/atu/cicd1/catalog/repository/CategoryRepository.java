
package ie.atu.cicd1.catalog.repository;

import ie.atu.cicd1.catalog.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository
        extends JpaRepository<Category, Long> {
}
