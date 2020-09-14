package com.concepts.elasticsearch.core;

import org.elasticsearch.client.RestHighLevelClient;

public class ElasticSearchClient {

    private RestHighLevelClient client;

    public ElasticSearchClient(RestHighLevelClient client) {
        this.client = client;
    }

    public RestHighLevelClient getRestHighLevelClient() {
        return client;
    }
}
