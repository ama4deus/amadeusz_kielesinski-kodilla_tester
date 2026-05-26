package com.kodilla.rest.controller;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

class ExternalApiRestAssuredTest {

    @Test
    void testUpdatePost() {
        Map<String, Object> updatedPostData = Map.of(
                "id", 1,
                "title", "Updated title",
                "body", "Updated body",
                "userId", 1
        );

        given()
                .header("Content-Type", "application/json")
                .body(updatedPostData)
                .when()
                .put("https://jsonplaceholder.typicode.com/posts/1")
                .then()
                .statusCode(200) // Weryfikacja statusu odpowiedzi
                .body("id", equalTo(1))
                .body("title", equalTo("Updated title"))
                .body("body", equalTo("Updated body"))
                .body("userId", equalTo(1));
    }
}