package com.concepts.elasticsearch.configuration;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.concepts.elasticsearch.core.ElasticSearchClient;

@Configuration
public class ElasticSearchConfiguration {

    @Bean
    public ElasticSearchClient elasticSearchClient() {
        return new ElasticSearchClient(new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http"))));
    }
}
