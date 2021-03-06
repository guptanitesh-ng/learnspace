package com.concepts.redis.client;

import javax.annotation.PostConstruct;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

@Component
public class RedisSubscriber implements MessageListener {

	@PostConstruct
	public void postConstruct() {
		System.out.println("Hey I am listening..........................");
	}
	
	@Override
	public void onMessage(Message message, byte[] pattern) {
		System.out.println("Message received: " + message + " on channel " + new String(pattern));
	}

}
