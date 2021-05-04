package jeon.donghoon.micro.composite.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ApiAddresses {

	private final String compositeAddress;
	private final String productAddress;
	private final String reviewAddress;
	private final String recommendationAddress;

}
