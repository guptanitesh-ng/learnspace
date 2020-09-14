package com.concepts.elasticsearch.core;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;
import org.elasticsearch.client.indices.GetMappingsRequest;
import org.elasticsearch.client.indices.GetMappingsResponse;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.IdsQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ElasticSearchClientTest {

    private static final String EMPLOYEES = "employees";
    @Autowired
    ElasticSearchClient elasticSearchClient;

    @Test
    public void testConnection() {
        RestHighLevelClient restHighLevelClient = elasticSearchClient.getRestHighLevelClient();
        assertNotNull(restHighLevelClient);
    }

    // @Test
    public void testCreateIndexWithMapping() throws IOException {
        RestHighLevelClient restHighLevelClient = elasticSearchClient.getRestHighLevelClient();
        CreateIndexRequest request = new CreateIndexRequest("candidates");
        XContentBuilder builder = XContentFactory.jsonBuilder();
        builder.startObject();
        builder.startObject("properties");
        builder.field("name", "keyword");
        builder.endObject();
        builder.endObject();
        request.mapping(builder);
        AcknowledgedResponse putMappingResponse = restHighLevelClient.indices().create(request,
                RequestOptions.DEFAULT);
        assertTrue(putMappingResponse.isAcknowledged());
    }

    @Test
    public void testGetIndexAndMapping() throws IOException {
        RestHighLevelClient restHighLevelClient = elasticSearchClient.getRestHighLevelClient();
        GetIndexRequest request = new GetIndexRequest(EMPLOYEES);
        GetIndexResponse getIndexResponse = restHighLevelClient.indices().get(request,
                RequestOptions.DEFAULT);
        assertTrue(Arrays.asList(getIndexResponse.getIndices()).contains(EMPLOYEES));
        System.out.println(getIndexResponse.getMappings());

        GetMappingsRequest getMappingsRequest = new GetMappingsRequest();
        getMappingsRequest.indices(EMPLOYEES);

        GetMappingsResponse mapping = restHighLevelClient.indices().getMapping(getMappingsRequest,
                RequestOptions.DEFAULT);
        Map<String, Object> sourceAsMap = mapping.mappings().get(EMPLOYEES).getSourceAsMap();
        System.out.println(sourceAsMap);

    }

    @Test
    public void search() {
        RestHighLevelClient restHighLevelClient = elasticSearchClient.getRestHighLevelClient();
        SearchRequest searchRequest = new SearchRequest(EMPLOYEES);
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.matchAllQuery());
        searchSourceBuilder.from(10);
        searchSourceBuilder.size(20);
        searchRequest.source(searchSourceBuilder);
        try {
            SearchResponse search = restHighLevelClient.search(searchRequest,
                    RequestOptions.DEFAULT);
            System.out.println(search.getHits().getTotalHits());
            search.getHits().forEach(h -> System.out.println(h.getSourceAsString()));
            System.out.println(search);
            assertNotNull(search);
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    // @Test
    public void searchPatientVisit() {
        RestHighLevelClient restHighLevelClient = elasticSearchClient.getRestHighLevelClient();
        SearchRequest searchRequest = new SearchRequest(
                "comply_md_application_patientvisit_development");
        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();
        List<QueryBuilder> should = boolQuery.should();
        should.add(QueryBuilders.termQuery("account_number", "00412190"));
        should.add(QueryBuilders.termQuery("mrn", "00412190"));

        // List<QueryBuilder> must = boolQuery.must();
        // must.add(boolQuery);

        IdsQueryBuilder idsQuery = QueryBuilders.idsQuery();
        idsQuery.addIds("46177503");

        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        // searchSourceBuilder.query(boolQuery);
        searchSourceBuilder.query(idsQuery);
        searchSourceBuilder.from(0);
        searchSourceBuilder.size(20);
        searchRequest.source(searchSourceBuilder);
        try {
            SearchResponse search = restHighLevelClient.search(searchRequest,
                    RequestOptions.DEFAULT);
            System.out.println(search);
            assertNotNull(search);
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    // @Test
    public void searchAggregation() {
        RestHighLevelClient restHighLevelClient = elasticSearchClient.getRestHighLevelClient();
        SearchRequest searchRequest = new SearchRequest(
                "comply_md_application_facility_development");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        // searchSourceBuilder.aggregation(AggregationBuilders.matchAllQuery());
        searchSourceBuilder.from(10);
        searchSourceBuilder.size(20);
        searchRequest.source(searchSourceBuilder);
        try {
            SearchResponse search = restHighLevelClient.search(searchRequest,
                    RequestOptions.DEFAULT);
            System.out.println(search);
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
