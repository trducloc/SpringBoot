import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class ProductController {

    @GetMapping("/products")
    public List<Product> getProducts() {
        // Tạo danh sách sản phẩm từ 5 đến 10 sản phẩm
        List<Product> products = new ArrayList<>();
        int numberOfProducts = (int) (Math.random() * 6) + 5; // Số sản phẩm từ 5 đến 10
        for (int i = 0; i < numberOfProducts; i++) {
            Product product = createRandomProduct();
            products.add(product);
        }
        return products;
    }

    // Hàm tạo thông tin ngẫu nhiên cho sản phẩm
    private Product createRandomProduct() {
        return new Product(
                UUID.randomUUID().toString(),
                getRandomName(),
                "Description " + UUID.randomUUID().toString().substring(0, 5),
                (int) (Math.random() * 1000) + 100,
                "Brand " + UUID.randomUUID().toString().substring(0, 3)
        );
    }

    // Một số tên ngẫu nhiên cho sản phẩm
    private String getRandomName() {
        String[] names = {"Product A", "Product B", "Product C", "Product D", "Product E"};
        int randomIndex = (int) (Math.random() * names.length);
        return names[randomIndex];
    }
}
