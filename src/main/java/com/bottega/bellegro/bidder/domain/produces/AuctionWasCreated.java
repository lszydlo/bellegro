package com.bottega.bellegro.bidder.domain.produces;

import com.bottega.bellegro.DomainEvent;
import com.bottega.bellegro.bidder.domain.AuctionId;
import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Value
public class AuctionWasCreated implements DomainEvent {
	private final LocalDateTime endDate;
	private final BigDecimal value;
	private final AuctionId auctionId;
}
