package ie.atu.cicd1.catalog.service;

import ie.atu.cicd1.catalog.model.Productmodel;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private final List<Productmodel> products = new ArrayList<>();
    private long nextId = 1;

    public List<Productmodel> getAll() {
        return products;
    }

    public Productmodel create(Productmodel product) {
        product.setId(nextId++);
        products.add(product);
        return product;
    }
}
