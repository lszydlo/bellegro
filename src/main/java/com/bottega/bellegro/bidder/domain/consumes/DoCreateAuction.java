package com.bottega.bellegro.bidder.domain.consumes;


import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class DoCreateAuction {

	@NotEmpty
	private BigDecimal minPrice;
	@NotEmpty
	private LocalDateTime endDate;
	@NotEmpty
	private UUID productId;
	@NotEmpty
	private UUID auctionId;




}
