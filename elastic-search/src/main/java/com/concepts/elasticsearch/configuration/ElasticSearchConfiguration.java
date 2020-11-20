package com.concepts.elasticsearch.configuration;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.concepts.elasticsearch.core.ElasticSearchClient;
import com.concepts.elasticsearch.configuration.ApplicationProperties;

@Configuration
public class ElasticSearchConfiguration {

	@Autowired
	private ApplicationProperties props;

	@Bean
	public ElasticSearchClient elasticSearchClient() {
		return new ElasticSearchClient(new RestHighLevelClient(RestClient
				.builder(new HttpHost(props.getHostname(), Integer.valueOf(props.getPort()), props.getScheme()))));
	}
}
