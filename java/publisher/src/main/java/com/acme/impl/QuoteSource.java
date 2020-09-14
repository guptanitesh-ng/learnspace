package com.acme.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.acme.publisher.Source;
import com.acme.util.Pair;
import com.acme.util.QuoteToken;

public class QuoteSource implements Source<QuoteToken<Integer, String>> {

	private final String[][] quotes = new String[][] {
			new String[] { "Beware", "of", "bugs", "in", "the", "above", "code;", "I", "have", "only", "proved", "it",
					"correct,", "not", "tried", "it." },
			new String[] { "Any", "inaccuracies", "in", "this", "index", "may", "be", "explained", "by", "the", "fact",
					"that", "it", "has", "been", "sorted", "with", "the", "help", "of", "a", "computer" } };

	private final Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();

	public QuoteSource() {
		// Code below to ensure all elements of the quotes array are processed.
		List<Integer> indexList = new ArrayList<Integer>();
		for (int i = 0; i < quotes[0].length; i++) {
			indexList.add(i);
		}
		Collections.shuffle(indexList);
		map.put(0, indexList);
		indexList = new ArrayList<Integer>();
		for (int i = 0; i < quotes[1].length; i++) {
			indexList.add(i);
		}
		Collections.shuffle(indexList);
		map.put(1, indexList);
	}

	@Override
	public Pair<String, QuoteToken<Integer, String>> getNext(int source) {
		if (map.get(source).size() == 0) {
			return new Pair<String, QuoteToken<Integer, String>>("Quote_" + (source + 1), null);
		}
		
		// Provision for sending the index along with the quote token.
		int index = map.get(source).get(0);
		Pair<String, QuoteToken<Integer, String>> pair = new Pair<String, QuoteToken<Integer, String>>(
				"Quote_" + (source + 1), new QuoteToken<Integer, String>(index, quotes[source][index]));
		map.get(source).remove(0);
		return pair;
	}
}
