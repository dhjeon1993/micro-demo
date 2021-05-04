package jeon.donghoon.micro.core.recommendation;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Recommendation {

	private final int id;
	private final int productId;
	private final String author;
	private final int rate;
	private final String content;
	private final String serviceAddress;

	public Recommendation() {
		this.id = 0;
		this.productId = 0;
		this.author = null;
		this.rate = 0;
		this.content = null;
		this.serviceAddress = null;
	}

}
