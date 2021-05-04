package jeon.donghoon.micro.core.recommendation;

import java.util.List;

public interface RecommendationApi {

	List<Recommendation> getRecommendations(int productId);

}
