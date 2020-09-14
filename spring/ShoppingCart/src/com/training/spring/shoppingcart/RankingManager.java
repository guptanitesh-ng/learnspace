package com.training.spring.shoppingcart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class RankingManager {

	@Autowired
	@Qualifier("first")
	private ProductRanking firstQuarterRanking;
	
	@Autowired
	@Qualifier("second")
	private ProductRanking secondQuarterRanking;
	
	@Autowired
	@Qualifier("third")
	private ProductRanking thirdQuarterRanking;
	
	@Autowired
	@Qualifier("last")
	private ProductRanking lastQuarterRanking;
	
	@Async
	public synchronized void updateRanking(Sale sale) {		
		Quarter quarter = Quarter.getQuarter(sale.getTime());
		ProductRanking ranking = null;
		switch (quarter) {
		case first:
			ranking = firstQuarterRanking;
			break;
		case second:
			ranking = secondQuarterRanking;
			break;
		case third:
			ranking = thirdQuarterRanking;
			break;
		case last:
			ranking = lastQuarterRanking;
			break;
		default:
			ranking = null;
		}
		for (Product product : sale.getCart().getItems()) {
			ranking.updateProductRank(product);
		}
	}
}
