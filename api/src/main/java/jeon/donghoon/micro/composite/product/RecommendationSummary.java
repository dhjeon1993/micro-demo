package jeon.donghoon.micro.composite.product;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RecommendationSummary {
	private final int id;
	private final String author;
	private final int rate;
}
