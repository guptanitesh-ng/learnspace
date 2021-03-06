package com.concepts.elasticsearch.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.elasticsearch.action.admin.cluster.settings.ClusterGetSettingsRequest;
import org.elasticsearch.action.admin.cluster.settings.ClusterGetSettingsResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.concepts.elasticsearch.core.ElasticSearchClient;

@RestController
public class ElasticSearchController {

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	private ElasticSearchClient elasticSearchClient;

	public ElasticSearchController(ElasticSearchClient elasticSearchClient) {
		this.elasticSearchClient = elasticSearchClient;
	}

	@RequestMapping("/check-connection")
	public String checkConnection() {
		System.out.println(elasticSearchClient.getRestHighLevelClient());
		return "Connection Successful";
	}

	@RequestMapping("/search")
	public String search() throws IOException {
		RestHighLevelClient restHighLevelClient = elasticSearchClient.getRestHighLevelClient();
		SearchRequest searchRequest = new SearchRequest("employees");
		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
		searchSourceBuilder.query(QueryBuilders.matchAllQuery());
		searchRequest.source(searchSourceBuilder);
		searchRequest.scroll(TimeValue.timeValueMinutes(11));

		SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
		String scrollId = searchResponse.getScrollId();
		LOGGER.debug("Received response: ", searchResponse);
		Arrays.asList(searchResponse.getHits().getHits())
				.forEach(h -> LOGGER.debug(h.getSourceAsString()));
		System.out.println("Scroll Id: " + scrollId);
		return searchResponse.getHits().getHits().toString();

	}

	@RequestMapping("/getClusterSettings")
	public Map<String, String> getClusterSettings() throws Exception {
		ClusterGetSettingsRequest request = new ClusterGetSettingsRequest();
		request.includeDefaults(true);
		ClusterGetSettingsResponse response = elasticSearchClient.getRestHighLevelClient().cluster()
				.getSettings(request, RequestOptions.DEFAULT);
		Settings persistentSettings = response.getPersistentSettings();
		Settings transientSettings = response.getTransientSettings();
		Settings defaultSettings = response.getDefaultSettings();
		Map<String, String> settings = new HashMap<>();
		defaultSettings.keySet().forEach(k -> settings.put(k, defaultSettings.get(k)));
		persistentSettings.keySet().forEach(k -> settings.put(k, defaultSettings.get(k)));
		transientSettings.keySet().forEach(k -> settings.put(k, defaultSettings.get(k)));
		return settings;
	}
}
