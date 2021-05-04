package jeon.donghoon.micro.core.review;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Review {
	private final int id;
	private final int productId;
	private final String author;
	private final String subject;
	private final String content;
	private final String serviceAddress;

	public Review() {
		this.id = 0;
		this.productId = 0;
		this.author = null;
		this.subject = null;
		this.content = null;
		this.serviceAddress = null;
	}
}
