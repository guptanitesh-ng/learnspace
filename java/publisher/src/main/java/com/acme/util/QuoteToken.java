package com.acme.util;

public class QuoteToken<U extends Comparable<U>, V> implements Comparable<QuoteToken<U, V>> {

	final U u;

	final V v;

	public QuoteToken(final U u, final V v) {
		this.u = u;
		this.v = v;
	}

	public U getIndex() {
		return u;
	}

	public V getToken() {
		return v;
	}

	@Override
	public String toString() {
		return " " + v;
	}

	@Override
	public int compareTo(QuoteToken<U, V> quoteToken) {
		return this.u.compareTo(quoteToken.getIndex());
	}

}
