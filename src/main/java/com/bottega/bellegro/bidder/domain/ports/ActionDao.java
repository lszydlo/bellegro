package com.bottega.bellegro.bidder.domain.ports;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ActionDao extends JpaRepository<UUID, AuctionRecord> {
}
