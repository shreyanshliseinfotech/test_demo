package com.resrapitest;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class NumericAssert {

    @Test
    public void test(){

        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        given().get("/users/1").then().assertThat()
                .body("address.zipcode", greaterThan("33263"));
    }
}
