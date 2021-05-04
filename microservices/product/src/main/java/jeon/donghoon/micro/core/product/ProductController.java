package jeon.donghoon.micro.core.product;

import jeon.donghoon.micro.util.http.ServiceUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProductController implements ProductApi{

    private final ServiceUtil serviceUtil;

    @Override
    @GetMapping("/products/{productId}")
    public Product getProduct(@PathVariable("productId") int productId) {
        return new Product(productId, "name-" + productId, 123, serviceUtil.getServiceAddress());
    }
}
