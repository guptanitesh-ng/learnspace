package com.training.restful.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class XMLClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		DefaultHttpClient client = new DefaultHttpClient();
		HttpGet get = new HttpGet("http://localhost:8080/RESTFulService/customer");
		get.addHeader("accept", "application/xml");
		HttpResponse response = client.execute(get);
		BufferedReader reader = new BufferedReader(new
				InputStreamReader(response.getEntity()
				.getContent()));
				String line = reader.readLine();
				while (line != null) {
					System.out.println(line);
					line = reader.readLine();
				}
	}

}
