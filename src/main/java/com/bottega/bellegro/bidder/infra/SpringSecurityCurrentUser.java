package com.bottega.bellegro.bidder.infra;

import com.bottega.bellegro.bidder.domain.CurrentUser;
import org.springframework.security.core.context.SecurityContextHolder;

public class SpringSecurityCurrentUser implements CurrentUser {
	@Override
	public void isSeller() {
		SecurityContextHolder.getContext().getAuthentication().getAuthorities();
	}
}
