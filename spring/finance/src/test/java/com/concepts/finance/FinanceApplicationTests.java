package com.concepts.finance;

import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FinanceApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public void testRestAssured() {
        RestAssured.given().auth().preemptive().basic("user1", UUID.randomUUID().toString()).and()
                .accept(ContentType.JSON).log().all().when().get("https://www.google.co.in/").then()
                .statusCode(HttpStatus.OK.value());
        RestAssured.given().header("Authorization",
                "License Y2FwZFRlc3RVc2VyOkI3NUIxNjM1LTNFNTItNEU3Ni1CQjhGLUUxMEFCNkJDNENBOQ==")
                .accept(ContentType.JSON).log().all().when().get("https://www.google.co.in/").then()
                .statusCode(HttpStatus.OK.value());
    }
}
