package com.training.spring.ioc.generator.sequence;

import java.text.DecimalFormat;

public class SequenceGenerator {

	private PrefixGenerator prefixGenerator;

	private SuffixGenerator suffixGenerator;

	private SequenceRepository sequenceRepository;

	private long count;

	public void setSequenceRepository(SequenceRepository sequenceRepository) {
		this.sequenceRepository = sequenceRepository;
	}

	public void setPrefixGenerator(PrefixGenerator prefixGenerator) {
		this.prefixGenerator = prefixGenerator;
	}

	public void setSuffixGenerator(SuffixGenerator suffixGenerator) {
		this.suffixGenerator = suffixGenerator;
	}

	public synchronized String generateSequence() {
		String generatedSequence = prefixGenerator.getPrefix()
				+ new DecimalFormat("0000").format(++count)
				+ suffixGenerator.getSuffix();
		sequenceRepository.storeSequence(generatedSequence);
		return generatedSequence;
	}

}
