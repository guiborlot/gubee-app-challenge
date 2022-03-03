package com.borlot.gubeeapp;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class ExampleResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
                .when().get("/products")
                .then()
                .statusCode(200);
    }

    @Test
    public void shouldReturnAListOfProduct_WhenFilterByMarket(){
        given()
                .when().get("/products?market=Móveis")
                .then()
                .statusCode(200)
                .body("[0].name", is("MadeiraMadeira"),
                        "[0].market", is("Móveis"),
                        "[0].id", is(1),
                        "[0].description", is("integração com a MadeiraMadeira"));
    }

    @Test
    public void shouldReturnAListOfProduct_WhenFilterByTechnology(){
        given()
                .when().get("/products?technology=Redis")
                .then()
                .statusCode(200)
                .body("[0].name", is("Americanas"),
                        "[0].market", is("Marketplace"),
                        "[0].id", is(2),
                        "[1].name",is("Amazon"),
                        "[1].market", is("Marketplace"),
                        "[1].id", is(3));
    }
}