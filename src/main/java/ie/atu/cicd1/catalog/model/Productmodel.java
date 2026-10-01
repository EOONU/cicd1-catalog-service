package ie.atu.cicd1.catalog.model;

import java.math.BigDecimal;

public class Productmodel {
    private Long id;
    private String name;
    private BigDecimal price;

    public Productmodel() {}

    public Productmodel(Long id, String name, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }
}