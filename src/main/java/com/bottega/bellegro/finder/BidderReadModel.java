package com.bottega.bellegro.finder;

import lombok.Data;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class BidderReadModel {

	private UUID auctionId;
	private LocalDateTime endTime;
	private Duration timeTillEnd;
	private BigDecimal currentPrice;

	public void calculate() {
		timeTillEnd = Duration.between(endTime, LocalDateTime.now());
	}
}
