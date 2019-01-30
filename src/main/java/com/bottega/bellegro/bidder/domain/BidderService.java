package com.bottega.bellegro.bidder.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BidderService {


	private CurrentUser currentUser;
	private AuctionsRepo repo;

	// cena większa od 0
	public void handle(DoCreateAuction command) {
		currentUser.isSeller();
		Auctions auctions = repo.load(command.getProductId());
		auctions.addAuction(command);
		repo.save(auctions);
	}

	class Auctions {

		List<Auction> auctions = new ArrayList<>();

		void addAuction(DoCreateAuction command) {
			// FIXME:
			if (auctions.stream()
					.anyMatch(auction -> auction.isActive() || auction.hasId(command.getAuctionId()))) {
				throw new RuntimeException("active auction exists");
			} else {
				auctions.add(new Auction(command.getAuctionId(),command.getEndDate(), Money.of(command.getMinPrice())));
			}
		}
	}

	private class Auction {
		private final UUID auctionId;
		private final LocalDateTime endDate;
		private final Money minPrice;
		private boolean isActive;

		Auction(UUID auctionId, LocalDateTime endDate, Money minPrice) {
			this.auctionId = auctionId;
			this.endDate = endDate;
			this.minPrice = minPrice;
		}

		boolean isActive() {
			return isActive;
		}

		boolean hasId(UUID auctionId) {
			return this.auctionId.equals(auctionId);
		}
	}
}
