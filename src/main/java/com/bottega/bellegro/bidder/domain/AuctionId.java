package com.bottega.bellegro.bidder.domain;

import java.util.UUID;

public class AuctionId {
	private final UUID auctionId;

	private AuctionId(UUID auctionId) {
		this.auctionId = auctionId;
	}

	public static AuctionId of(UUID auctionId) {
		return new AuctionId(auctionId);
	}

	public UUID getAuctionId() {
		return auctionId;
	}
}
