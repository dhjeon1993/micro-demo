package jeon.donghoon.micro.core.review;

import java.util.List;

public interface ReviewApi {
	List<Review> getReviews(int productId);
}
