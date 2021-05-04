package jeon.donghoon.micro.composite.product;

import com.fasterxml.jackson.databind.ObjectMapper;
import jeon.donghoon.micro.core.product.Product;
import jeon.donghoon.micro.core.product.ProductApi;
import jeon.donghoon.micro.core.recommendation.Recommendation;
import jeon.donghoon.micro.core.recommendation.RecommendationApi;
import jeon.donghoon.micro.core.review.Review;
import jeon.donghoon.micro.core.review.ReviewApi;
import jeon.donghoon.micro.util.exception.InvalidInputException;
import jeon.donghoon.micro.util.exception.NotFoundException;
import jeon.donghoon.micro.util.http.HttpErrorInfo;
import jeon.donghoon.micro.util.http.ServiceUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.HttpMethod.GET;

@RequiredArgsConstructor
@Slf4j
public class ProductCompositeIntegration implements ProductApi, RecommendationApi, ReviewApi {

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    private final String productApiUrl;
    private final String recommendationApiUrl;
    private final String reviewApiUrl;



    public Product getProduct(int productId) {

        try {
            String url = productApiUrl;
            log.debug("Will call getProduct API on URL: {}", url);

            Product product = restTemplate.getForObject(url, Product.class, productId);
            log.debug("Found a product with id: {}", product.getId());

            return product;

        } catch (HttpClientErrorException ex) {
            switch (ex.getStatusCode()) {
                case NOT_FOUND:
                    throw new NotFoundException(getErrorMessage(ex));

                case UNPROCESSABLE_ENTITY:
                    throw new InvalidInputException(getErrorMessage(ex));

                default:
                    log.warn("Got an unexpected HTTP error: {}, will rethrow it", ex.getStatusCode());
                    log.warn("Error body: {}", ex.getResponseBodyAsString());
                    throw ex;
            }
        }
    }

    private String getErrorMessage(HttpClientErrorException ex) {
        try {
            return objectMapper.readValue(ex.getResponseBodyAsString(), HttpErrorInfo.class).getMessage();
        } catch (IOException ioex) {
            return ex.getMessage();
        }
    }

    public List<Recommendation> getRecommendations(int productId) {

        try {
            String url = recommendationApiUrl;

            log.debug("Will call getRecommendations API on URL: {}", url);
            List<Recommendation> recommendations = restTemplate
                    .exchange(url, GET, null, new ParameterizedTypeReference<List<Recommendation>>() {}, productId)
                    .getBody();

            log.debug("Found {} recommendations for a product with id: {}", recommendations.size(), productId);
            return recommendations;

        } catch (Exception ex) {
            log.warn("Got an exception while requesting recommendations, return zero recommendations: {}", ex.getMessage());
            return new ArrayList<>();
        }
    }

    public List<Review> getReviews(int productId) {

        try {
            String url = reviewApiUrl;

            log.debug("Will call getReviews API on URL: {}", url);
            List<Review> reviews = restTemplate
                    .exchange(url, GET, null, new ParameterizedTypeReference<List<Review>>() {}, productId)
                    .getBody();

            log.debug("Found {} reviews for a product with id: {}", reviews.size(), productId);
            return reviews;

        } catch (Exception ex) {
            log.warn("Got an exception while requesting reviews, return zero reviews: {}", ex.getMessage());
            return new ArrayList<>();
        }
    }
}
