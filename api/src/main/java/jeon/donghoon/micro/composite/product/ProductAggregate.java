package jeon.donghoon.micro.composite.product;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ProductAggregate {

	private final int id;
	private final String name;
	private final int weight;
	private final List<RecommendationSummary> recommendations;
	private final List<ReviewSummary> reviews;
	private final ApiAddresses apiAddresses;
}
