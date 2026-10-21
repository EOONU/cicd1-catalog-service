
package ie.atu.cicd1.catalog.service;

import ie.atu.cicd1.catalog.dto.CreateProductRequest;
import ie.atu.cicd1.catalog.model.Category;
import ie.atu.cicd1.catalog.model.Product;
import ie.atu.cicd1.catalog.repository.CategoryRepository;
import ie.atu.cicd1.catalog.repository.ProductRepository;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repository;
    private final CategoryRepository categoryRepository;

    public List<Product> getByMaxPrice(BigDecimal maxPrice) {
        return repository.findByMaxPrice(maxPrice);
    }
    public ProductService(
            ProductRepository repository,
            CategoryRepository categoryRepository) {

        this.repository = repository;
        this.categoryRepository = categoryRepository;
    }
    public List<Product> getByCategoryName(String categoryName) {
        return repository.findByCategoryName(categoryName);
    }

    public List<Product> getAll() {
        return repository.findAll();
    }

    public Product getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Product not found"
                ));
    }

    public List<Product> getByMinimumPrice(BigDecimal minPrice) {
        return repository.findByMinimumPrice(minPrice);
    }

    public Product createProduct(CreateProductRequest request) {

        if (request.categoryId() == null) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "categoryId is required"
            );
        }

        Category category = categoryRepository
                .findById(request.categoryId())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.BAD_REQUEST,
                        "Category does not exist"
                ));

        Product product = new Product();
        product.setName(request.name());
        product.setPrice(request.price());
        product.setCategory(category);

        return repository.save(product);
    }
}
