package com.acme.publisher;

import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

import com.acme.util.Pair;

public class Publisher<E> implements Runnable {

	private final Source<E> source;
	HashMap<String, List<Listener<E>>> listeners = new HashMap<String, List<Listener<E>>>();

	public Publisher(Source<E> source) {
		this.source = source;
	}

	public synchronized void subscribe(String channel, Listener<E> listener) {
		// 1. Fix the null pointer issue with listener bucket per channel.
		if (listeners.get(channel) == null) {
			// 5. Using the concurrently modifiable list to handle removal in
			// the event of unsubscription.
			listeners.put(channel, new CopyOnWriteArrayList<Listener<E>>());
		}
		listeners.get(channel).add(listener);
	}

	public synchronized void unsubscribe(String channel, Listener<E> listener) {
		List<Listener<E>> lst = listeners.get(channel);
		lst.remove(listener);
		
		// To terminate the program once all listeners have unsubscribed.
		for (List<Listener<E>> listeners: listeners.values()) {
			if (!listeners.isEmpty()) 
				return;
		}
		System.exit(0);
	}

	@Override
	public void run() {
		while (!Thread.interrupted()) {
			try {
				Random r = new Random();
				int chooseQuote = r.ints(0, 2).findFirst().getAsInt();
				Pair<String, E> next = source.getNext(chooseQuote);
				synchronized (next) {
					for (Listener<E> listener : listeners.get(next.first())) {
						if (next.second() == null) {
							listener.finishConsumption(next.first(), this);
						} else {
							listener.onEvent(next.first(), next.second());
						}
					}
				}
			} catch (Throwable t) {
				// 3. Log the error trace, should be done using logging utility,
				// using printStackTrace for brevity.
				t.printStackTrace();
			}
		}
	}

}
