package com.training.spring.ioc.generator.sequence;

public class ConstantSuffixGenerator implements SuffixGenerator {

	private String value;
	
	public ConstantSuffixGenerator (String value) {
		this.value = value;
	}
	
	@Override
	public String getSuffix() {
		return value;
	}

}
