package jeon.donghoon.micro.core.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class Product {
	private final int id;
	private final String name;
	private final int weight;
	private final String serviceAddress;

	public Product() {
		this.id = 0;
		this.name = null;
		this.weight = 0;
		this.serviceAddress = null;
	}
}
