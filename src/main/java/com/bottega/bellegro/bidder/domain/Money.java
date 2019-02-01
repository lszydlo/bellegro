package com.bottega.bellegro.bidder.domain;

import java.math.BigDecimal;

class Money {
	private final BigDecimal minPrice;

	private Money(BigDecimal minPrice) {
		this.minPrice = minPrice;
	}

	static Money of(BigDecimal minPrice) {
		if (minPrice.compareTo(BigDecimal.ZERO) > 0) {
			return new Money(minPrice);
		} else {
			throw new RuntimeException("sdsds");
		}
	}

	BigDecimal value() {
		return minPrice;
	}
}
