package jeon.donghoon.micro.composite.product;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ApiAddresses {

	private final String compositeAddress;
	private final String productAddress;
	private final String reviewAddress;
	private final String recommendationAddress;

}
