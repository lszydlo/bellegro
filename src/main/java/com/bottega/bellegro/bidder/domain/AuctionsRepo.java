package com.bottega.bellegro.bidder.domain;

import com.bottega.bellegro.bidder.domain.ports.ActionDao;

import java.util.UUID;
import java.util.function.Consumer;

class AuctionsRepo {


	ActionDao actionDao;

	BidderService.Auctions load(UUID productId) {
		return null;

	}

	void save(BidderService.Auctions auctions) {

	}

	BidderService.Auction loadOne(UUID auctionId) {
		return null;
	}

	void saveOne(BidderService.Auction auction) {

	}

	void accept(UUID productId, Consumer<BidderService.Auctions> consummer) {
		BidderService.Auctions auctions = load(productId);
		consummer.accept(auctions);
		save(auctions);
	}
	void accept(AuctionId auctionId, Consumer<BidderService.Auction> consummer) {
		BidderService.Auction auctions = loadOne(auctionId.getAuctionId());
		consummer.accept(auctions);
		saveOne(auctions);
	}
}
