package com.example.controller;

import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.equalTo;

/**
 * @author Jonatan Ivanov
 */
public class CoverageDemoControllerFunctionalTest {
    @Test
    public void test() {
        given()
            .baseUri("http://localhost:8080")
            .basePath("/coverage-demo").
        when()
            .get("/echo/Hi").
        then()
            .statusCode(200)
            .body(anything(), equalTo("Hi"));
    }
}
