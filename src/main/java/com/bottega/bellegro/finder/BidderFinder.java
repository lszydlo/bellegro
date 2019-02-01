package com.bottega.bellegro.finder;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcOperations;

@AllArgsConstructor
public class BidderFinder {

	JdbcOperations operations;

	BidderReadModel findOne() {
		BidderReadModel bidderReadModel = operations.queryForObject("select * from auctons_read_model wheer..", new BeanPropertyRowMapper<>());
		bidderReadModel.calculate();
		return bidderReadModel;
	}

}
