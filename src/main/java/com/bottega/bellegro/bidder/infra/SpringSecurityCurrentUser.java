package com.bottega.bellegro.bidder.infra;

import com.bottega.bellegro.bidder.domain.ports.CurrentUser;
import com.bottega.bellegro.bidder.domain.ports.Seller;
import org.springframework.security.core.context.SecurityContextHolder;

public class SpringSecurityCurrentUser implements CurrentUser {
	@Override
	public void isSeller() {
		SecurityContextHolder.getContext().getAuthentication().getAuthorities();
	}

	@Override
	public Seller getSeller() {
		return null;
	}
}
