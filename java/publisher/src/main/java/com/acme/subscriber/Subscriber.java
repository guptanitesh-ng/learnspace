package com.acme.subscriber;

import java.util.Set;
import java.util.TreeSet;

import com.acme.publisher.Listener;
import com.acme.publisher.Publisher;

public class Subscriber<E> implements Listener<E> {

	String name;

	private Set<E> tokenSet;

	public Subscriber(String name, String channel, Publisher<E> publisher) {
		this.name = name;
		publisher.subscribe(channel, this);
		this.tokenSet = new TreeSet<E>();
	}

	@Override
	public void onEvent(final String channel, final E e) {
		tokenSet.add(e);
	}

	// New method to handle the end of consumption.
	@Override
	public void finishConsumption(String channel, Publisher<E> publisher) {
		System.out.println(name + " " + tokenSet.toString());
		publisher.unsubscribe(channel, this);

	}
}
