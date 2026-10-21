
package ie.atu.cicd1.catalog.controller;

import ie.atu.cicd1.catalog.dto.CreateProductRequest;
import ie.atu.cicd1.catalog.model.Product;
import ie.atu.cicd1.catalog.service.ProductService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping("/by-category")
    public List<Product> getByCategory(
            @RequestParam("name") String categoryName) {
        return productService.getByCategoryName(categoryName);
    }
    @GetMapping("/max-price")
    public List<Product> getByMaxPrice(
            @RequestParam("price") BigDecimal price) {
        return productService.getByMaxPrice(price);
    }
    @GetMapping
    public List<Product> getAll() {
        return productService.getAll();
    }

    @GetMapping("/min-price")
    public List<Product> getByMinimumPrice(
            @RequestParam("price") BigDecimal price) {
        return productService.getByMinimumPrice(price);
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id) {
        return productService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product createProduct(
            @RequestBody CreateProductRequest request) {
        return productService.createProduct(request);
    }
}
