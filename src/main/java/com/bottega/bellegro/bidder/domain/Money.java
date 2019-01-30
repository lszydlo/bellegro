package com.bottega.bellegro.bidder.domain;

import java.math.BigDecimal;

public class Money {
	private final BigDecimal minPrice;

	private Money(BigDecimal minPrice) {
		this.minPrice = minPrice;
	}

	public static Money of(BigDecimal minPrice) {
		if (minPrice.compareTo(BigDecimal.ZERO) > 0) {
			return new Money(minPrice);
		} else {
			throw new RuntimeException("sdsds");
		}
	}

}
