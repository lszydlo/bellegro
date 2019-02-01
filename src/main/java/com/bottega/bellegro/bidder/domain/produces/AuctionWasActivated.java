package com.bottega.bellegro.bidder.domain.produces;

import com.bottega.bellegro.DomainEvent;
import com.bottega.bellegro.bidder.domain.AuctionId;
import lombok.Value;

@Value
public class AuctionWasActivated implements DomainEvent {
	private AuctionId auctionId;

}
