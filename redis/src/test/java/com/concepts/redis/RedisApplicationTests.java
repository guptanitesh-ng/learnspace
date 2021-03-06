package com.concepts.redis;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import com.concepts.redis.client.Entity;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.path.json.config.JsonPathConfig;
import com.jayway.restassured.response.Response;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class RedisApplicationTests {

	private static final String HTTP_LOCALHOST = "http://localhost:";
	@LocalServerPort
	private int port;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testCachingUpdatingAndEviction() {
		Response response = RestAssured.given().get(HTTP_LOCALHOST + port + "/remove");
		assert("Spring Boot Archived".equals(response.getBody().asString()));
		 response = RestAssured.given().get(HTTP_LOCALHOST + port + "/hello");
		assert("Spring Boot".equals(response.getBody().asString()));
		response = RestAssured.given().get(HTTP_LOCALHOST + port + "/update");
		assert("Spring Boot Current".equals(response.getBody().asString()));
		
	}

	@Test
	public void testThinkingSortedSets() {
		Response response = RestAssured.given().accept(ContentType.JSON).when()
				.get(HTTP_LOCALHOST + port + "/playSortedSets").thenReturn();
		assert (response.getStatusCode() == 200);
		JsonPath jsonPath = response.getBody().jsonPath(new JsonPathConfig());
		Map<Object, Object> map = jsonPath.getMap("data");
		assert ((Integer) map.get("Positive Score Element Count") == 3);
		jsonPath.prettyPrint();
	}

	@Test
	public void testPipelining() {
		Response response = RestAssured.given().accept(ContentType.JSON).when()
				.get(HTTP_LOCALHOST + port + "/tryPipelining").thenReturn();
		assert (response.getStatusCode() == 200);
		assertTrue(response.getBody().asString().contains("11"));
	}

	@Test
	public void testPublishing() {
		Response response = RestAssured.given().contentType(ContentType.JSON)
				.body(new Entity(1, "Entity published via post request"))
				.post(HTTP_LOCALHOST + port + "/letsPublish").thenReturn();
		assert (response.getStatusCode() == 202);
	}

	@Test
	public void testStreaming() {
		Response response = RestAssured.given().contentType(ContentType.JSON)
				.body(new Entity(1, "Entity streamed to log")).post(HTTP_LOCALHOST + port + "/checkoutStreaming")
				.thenReturn();
		assert (response.getStatusCode() == 202);
	}

	@Test
	public void testTransaction() {
		Response response = RestAssured.given().get(HTTP_LOCALHOST + port + "/runTransaction").thenReturn();
		assert (response.getStatusCode() == 200);
		List<Entity> asList = Arrays.asList(response.getBody().as(Entity[].class));
		assert (asList.size() == 4);
	}
}
