## JPQL & JPA Relationships Lab

This lab adds JPQL queries, a Category entity, and a many-to-one relationship between Product and Category.

### GET endpoints

- `GET /products`
- `GET /products/{id}`
- `GET /products/min-price?price=100`
- `GET /products/by-category?name=Computers`
- `GET /products/max-price?price=50` (optional)

### POST endpoint

`POST /products`

Example request:

```json
{
  "name": "Keyboard",
  "price": 79.99,
  "categoryId": 2
}
```

Replace `2` with an existing Category ID.

The service validates `categoryId`, loads the matching Category from the database, and saves the new Product with that relationship.

### Database

- H2 database: `catalogdb`
- Tables: `PRODUCTS`, `CATEGORIES`
- Relationship: Product `@ManyToOne` Category
- SQL JOIN: `products.category_id = categories.id`
- JPQL JOIN: `JOIN p.category c`

The Order microservice remains unchanged.
