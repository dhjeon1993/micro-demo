package jeon.donghoon.micro;

import com.fasterxml.jackson.databind.ObjectMapper;
import jeon.donghoon.micro.composite.product.ApiAddresses;
import jeon.donghoon.micro.composite.product.ProductCompositeIntegration;
import jeon.donghoon.micro.util.http.ServiceUtil;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.sql.DataSource;

@SpringBootApplication
@EnableConfigurationProperties
@RequiredArgsConstructor
public class ProductCompositeApplication {

	private final ObjectMapper objectMapper;

	public static void main(String[] args) {
		SpringApplication.run(ProductCompositeApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	public ServiceUtil serviceUtil(@Value("${server.port}")String port) {
		return new ServiceUtil(port);
	}

	@Bean
	public ProductCompositeIntegration productCompositeIntegration(Apis apis) {
		return new ProductCompositeIntegration(
				restTemplate(),
				objectMapper,
				apis.getProductAddress(),
				apis.getRecommendationAddress(),
				apis.getReviewAddress());
	}

	@ConfigurationProperties("api")
	@Component
	@Getter
	@Setter
	public static class Apis {
		private String productAddress;
		private String reviewAddress;
		private String recommendationAddress;
		private String compositeAddress;
	}

}
