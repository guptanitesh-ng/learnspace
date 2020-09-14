package com.training.spring.transaction;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class BookShopDAOImpl implements BookShopDAO {

	@Override
	public String purchaseBook() {
		
		return null;
	}

}
