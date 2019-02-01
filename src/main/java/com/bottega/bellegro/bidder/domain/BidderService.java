package com.bottega.bellegro.bidder.domain;

import com.bottega.bellegro.DomainEvent;
import com.bottega.bellegro.bidder.domain.consumes.DoActivateAuction;
import com.bottega.bellegro.bidder.domain.consumes.DoCreateAuction;
import com.bottega.bellegro.bidder.domain.ports.CurrentUser;
import com.bottega.bellegro.bidder.domain.ports.Seller;
import com.bottega.bellegro.bidder.domain.produces.AuctionWasActivated;
import com.bottega.bellegro.bidder.domain.produces.AuctionWasCreated;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BidderService {


	private CurrentUser currentUser;
	private AuctionsRepo repo;

	public void handle(DoCreateAuction command) {
		repo.accept(command.getProductId(),
				auctions -> {
					currentUser.isSeller();
					auctions.addAuction(command);
				});
	}

	public void handle(DoActivateAuction command) {
		repo.accept(AuctionId.of(command.getAuctionId()),
				auction -> {
					Seller seller = currentUser.getSeller();
					auction.activate(seller);
				});
	}

	class Auctions {

		List<Auction> auctions = new ArrayList<>();

		void addAuction(DoCreateAuction command) {
			// FIXME:
			if (auctions.stream().anyMatch(Auction::isActive)) {
				throw new RuntimeException("active auction exists");
			} else if (auctions.stream().anyMatch(auction -> auction.hasId(command.getAuctionId()))) {
				throw new RuntimeException("auction already exists");
			} else {
				auctions.add(new Auction(
						AuctionId.of(command.getAuctionId()),
						command.getEndDate(),
						Money.of(command.getMinPrice())));
			}
		}
	}

	class Auction {

		private List<DomainEvent> events = new ArrayList<>();

		private final AuctionId auctionId;
		private final LocalDateTime endDate;
		private final Money minPrice;
		private boolean isActive;
		private UUID ownerId;

		Auction(AuctionId auctionId, LocalDateTime endDate, Money minPrice) {
			this.auctionId = auctionId;
			this.endDate = endDate;
			this.minPrice = minPrice;
			this.isActive = false;
			events.add(new AuctionWasCreated(endDate, minPrice.value(), auctionId));
		}

		boolean isActive() {
			return isActive;
		}

		boolean hasId(UUID auctionId) {
			return this.auctionId.equals(auctionId);
		}

		void activate(Seller seller) {
			if (seller.hasId(ownerId)) {
				this.isActive = true;
				events.add(new AuctionWasActivated(auctionId));
			} else {
				throw new RuntimeException();
			}
		}
	}

}
