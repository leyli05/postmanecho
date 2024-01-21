package ru.netology.test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.Test;

public class PostmanEcho {

    @Test
    void shouldTestSomeData() {
        given()
                .baseUri("https://postman-echo.com")
                .contentType("text/plain; charset=UTF-8")
                .body("Hello world!")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("data", equalTo("Hello world!"))
        ;
    }

    @Test
    void shouldTestGetArgsFoo1Value() {
        given()
                .baseUri("https://postman-echo.com")
                .contentType("text/plain; charset=UTF-8")
                .when()
                .get("/get?foo1=bar1&foo2=bar2")
                .then()
                .statusCode(200)
                .body("args.foo1", equalTo("bar1"))
                .headers("content-length", "392")
        ;
    }

    @Test
    void shouldTestGetArgsFoo2ValueCrush() {
        given()
                .baseUri("https://postman-echo.com")
                .contentType("text/plain; charset=UTF-8")
                .body("some data")
                .when()
                .get("/get?foo1=bar1&foo2=bar2")
                .then()
                .statusCode(200)
                .body("args.foo2", equalTo("bar1"))
        ;
    }

    @Test
    void shouldTestPost() {
        given()
                .baseUri("https://postman-echo.com")
                .body("handWave")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("data", equalTo("handWave"))

        ;
    }

    @Test
    void shouldRequestHeaders() {
        given()
                .baseUri("https://postman-echo.com")
                .when()
                .get("/headers")
                .then()
                .statusCode(200)
                .headers("Content-Length", "255");

    }
}