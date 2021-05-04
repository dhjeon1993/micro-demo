package jeon.donghoon.micro.core.review;

import jeon.donghoon.micro.util.http.ServiceUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ReviewController implements ReviewApi{

    private final ServiceUtil serviceUtil;

    @Override
    public List<Review> getReviews(int productId) {
        return null;
    }
}
