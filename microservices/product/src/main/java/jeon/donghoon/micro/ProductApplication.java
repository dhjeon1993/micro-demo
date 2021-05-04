package jeon.donghoon.micro;

import jeon.donghoon.micro.util.http.ServiceUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);
	}

	@Bean
	public ServiceUtil serviceUtil(@Value("${server.port}")String port) {
		return new ServiceUtil(port);
	}

}
