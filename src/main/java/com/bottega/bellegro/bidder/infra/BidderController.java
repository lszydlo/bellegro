package com.bottega.bellegro.bidder.infra;

import com.bottega.bellegro.bidder.domain.BidderService;
import com.bottega.bellegro.bidder.domain.consumes.DoCreateAuction;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.UUID;

@RestController
@AllArgsConstructor
public class BidderController {

	private BidderService bidderService;

	@PutMapping("/auctions/{auction_id}")
	public ResponseEntity<Void> createAuction(@RequestBody DoCreateAuction command, @PathVariable UUID auction_id, UriComponentsBuilder builder) {

		bidderService.handle(command);

		return ResponseEntity.created(builder.build().toUri()).build();
	}

}
