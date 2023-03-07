package com.manifest.concept.concurrency;

import org.junit.Test;

public class WordCounterTest {

	@Test
	public void testWordCounter() {
		new WordCounter().readFilesToPrintWordCount("C:\\Users\\nitesh.gupta\\learnspace\\java\\fortify");
	}
}
