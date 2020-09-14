package com.training.spring.shoppingcart;

import java.util.Calendar;
import java.util.Date;

public enum Quarter {

	first, second, third, last;
	
	public static Quarter getQuarter(Date saleTime) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(saleTime);
		int month = calendar.get(Calendar.MONTH);
		if (month >= 0 && month <=2) {
			return first;
		}
		if (month >= 3 && month <=5) {
			return second;
		}
		if (month >= 6 && month <=8) {
			return third;
		}
		if (month >= 9 && month <=11) {
			return last;
		}
		return null;
	}
}
