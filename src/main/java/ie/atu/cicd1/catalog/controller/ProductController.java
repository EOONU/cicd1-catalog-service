package ie.atu.cicd1.catalog.controller;

import ie.atu.cicd1.catalog.model.Productmodel;
import ie.atu.cicd1.catalog.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public List<Productmodel> getAll() {
        return service.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Productmodel create(@RequestBody Productmodel product) {
        return service.create(product);
    }
}