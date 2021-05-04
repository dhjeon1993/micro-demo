package jeon.donghoon.micro.core.product;

import jeon.donghoon.micro.util.exception.InvalidInputException;
import jeon.donghoon.micro.util.exception.NotFoundException;
import jeon.donghoon.micro.util.http.ServiceUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ProductController implements ProductApi{

    private final ServiceUtil serviceUtil;

    @Override
    @GetMapping("/products/{productId}")
    public Product getProduct(@PathVariable("productId") int productId) {

        log.debug("/product return the found product for productId = {}", productId);

        if (productId < 1) {
            throw new InvalidInputException("Invalid productId: " + productId);
        }

        if (productId == 13) {
            throw new NotFoundException("No product found for productId: " + productId);
        }

        return new Product(productId, "name-" + productId, 123, serviceUtil.getServiceAddress());
    }
}
