package vn.techmaster.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.techmaster.demo.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/products")
public class ProductController {

    @GetMapping
    public List<Product> getProducts() {
        // Tao random 5 - 10 products
        int minProducts = 5;
        int maxProducts = 10;
        int numberOfProducts = new Random().nextInt(maxProducts - minProducts + 1) + minProducts;

        List<Product> products = new ArrayList<>();

        for (int i = 0; i < numberOfProducts; i++) {
            // random thong tin san pham moi
            Product product = new Product();
            product.setId(generateProductId());
            product.setName("Iphone " + new Random().nextInt(15) );
            product.setDescription("Description for Product " + (i + 1));
            product.setPrice(new Random().nextInt(900) + 99);
            product.setBrand("Apple");

            products.add(product);
        }

        return products;
    }

    // random id
    private String generateProductId() {
        return String.valueOf(new Random().nextInt(900) + 100);
    }
}
