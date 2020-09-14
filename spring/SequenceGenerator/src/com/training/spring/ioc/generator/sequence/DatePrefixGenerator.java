package com.training.spring.ioc.generator.sequence;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DatePrefixGenerator implements PrefixGenerator {

	@Override
	public String getPrefix() {
		DateFormat format = new SimpleDateFormat("yyyyMMdd");
		return format.format(Calendar.getInstance().getTime());
	}

}
