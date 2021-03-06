package com.concepts.redis.controller;

import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.concepts.redis.client.Entity;
import com.concepts.redis.client.RedisClient;

@RestController
public class RedisController {

	@Autowired
	private RedisClient redisClient;

	@RequestMapping("/hello")
	public String sayHello(@RequestParam(value = "name", defaultValue = "Spring Boot") String name) {
		return (redisClient.getCacheValue(name));
		//return "Hello " + name + "!!!";
	}
	
	@RequestMapping("/update")
	public String update(@RequestParam(value = "name", defaultValue = "Spring Boot") String name) {
		return redisClient.updateCacheValue(name);
		//return "Hello " + name + "!!!";
	}
	
	@RequestMapping("/remove")
	public String remove(@RequestParam(value = "name", defaultValue = "Spring Boot") String name) {
		return redisClient.evictCacheValue();
		//return "Hello " + name + "!!!";
	}

	@RequestMapping("/customizations")
	public String executeCustomizations() {
		System.out.println(redisClient.tryCustomKeyAndDynamicCache());
		System.out.println(redisClient.tryCustomSerialization());
		return "Hope it's clear now.";
	}

	@RequestMapping("/getAllKeys")
	public Set<String> getAllKeysForCache(@RequestParam(value = "cache") String cache) throws Exception {
		return redisClient.getKeys(cache);
	}

	@RequestMapping("/getEntries")
	public Map<Object, Object> getEntriesForKey(@RequestParam(value = "cache") String cache,
			@RequestParam(value = "key") String key) {
		return redisClient.getEntries(cache, key);
	}

	@RequestMapping("/playSortedSets")
	public Object playSortedSets() {
		return redisClient.thinkingRedisSortedSets();
	}
	
	@RequestMapping("/tryPipelining")
	public Object tryPipelining() {
		return redisClient.pipelining();
	}
	
	@RequestMapping("/letsPublish")
	public ResponseEntity<String> publish(@RequestBody Entity requestBody) {
		redisClient.publish(requestBody);
		return new ResponseEntity<>("Successfully published messages.", HttpStatus.ACCEPTED);
	}
	
	@RequestMapping("/checkoutStreaming")
	public ResponseEntity<String> stream(@RequestBody Entity requestBody) {
		redisClient.appendStream();
		return new ResponseEntity<>("Successfully streamed messages.", HttpStatus.ACCEPTED);
	} 
	
	@RequestMapping("/runTransaction")
	public Object transact() {
		return redisClient.handleTransactions();
	}
}
