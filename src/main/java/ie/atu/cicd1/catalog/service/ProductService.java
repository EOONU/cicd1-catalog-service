package ie.atu.cicd1.catalog.service;

import ie.atu.cicd1.catalog.model.Product;
import ie.atu.cicd1.catalog.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> getAll() {
        return repository.findAll();
    }

    public Product create(Product product) {
        product.setId(null);
        return repository.save(product);
    }
}