package com.training.spring.jdbc;

import org.springframework.dao.DataIntegrityViolationException;

public class MyDuplicateKeyException extends DataIntegrityViolationException {

	public MyDuplicateKeyException(String msg) {
		super(msg);
	}
	
	public MyDuplicateKeyException(String msg, Throwable cause) {
		super(msg, cause);		
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 4188803454488728499L;

}
