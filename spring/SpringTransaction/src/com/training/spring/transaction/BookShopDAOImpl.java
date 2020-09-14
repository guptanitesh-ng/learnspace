package com.training.spring.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
//@Transactional
public class BookShopDAOImpl implements BookShopDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public String purchaseBook() {
		// buy a book worth 50 bucks
		jdbcTemplate.update("update book set stock_unit = stock_unit - 1 where isbn = 'u3fy4834' ");
		int price = jdbcTemplate.queryForInt("select price from book where isbn = 'u3fy4834' ");
		// update user balance
		jdbcTemplate.update("update account set balance = balance - ?", price);
		return "purchase successful";
	}

}
