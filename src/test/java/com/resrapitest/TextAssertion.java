package com.resrapitest;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class TextAssertion {

    @Test
    public void textAsset(){

        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        given().get("/users/1").then().assertThat()
                .body("name", equalTo("Leanne Graham"))
                .and()
                .body("address.city", is(equalTo("Gwenborough")))
                .and()
                .body("address.geo.lng", is("81.1496"))
                .and()
                .body("name", equalToIgnoringCase("Leanne Graham"));

    }

    @Test
    public void textAsset_One(){

        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        given().get("/users/1").then().assertThat()
                .body("address.street", startsWith("Kulas"))
                .and()
                .body("address.street", endsWith("Light"));
    }

    @Test
    public void textAsset_Two(){

        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        given().get("/users/1").then().assertThat()
                .body("address.geo", hasKey("lng"))
                .and()
                .body("address", hasValue("92998-3874"))
                .and()
                .body("address.geo", hasEntry("lng", "81.1496"));


    }

    @Test
    public void textAsset_three(){

        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        given().get("/users").then().assertThat()
                .body("address.zipcode", hasItem("59590-4157"));
    }
}
