package com.concepts.redis.client;

import javax.annotation.PostConstruct;

import org.springframework.data.redis.connection.stream.MapRecord;
import org.springframework.data.redis.stream.StreamListener;

public class RedisStreamListener implements StreamListener<String, MapRecord<String, String, String>> {

	@PostConstruct
	public void PostConstruct() {
		System.out.println("Listening to stream");
	}

	@Override
	public void onMessage(MapRecord<String, String, String> message) {
		System.out.println("message as received: " + message);

	}

}
