package com.resrapitest;

import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;

import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;


public class SwApiTest {

    @Test
    public void planetTest() {

        Response response = given()
            .contentType(ContentType.XML)
            .accept(ContentType.JSON)
            .when()
            .request(Method.GET, "https://swapi.dev/api/planets/1").then()
            .extract().response();

          System.out.println(response.getBody().prettyPrint());

          JSONObject json = new JSONObject(response.asString());
          System.out.println("json ===== "+ json);

          String name = json.get("name").toString();
          int statusCode = response.getStatusCode();
          String diameter = json.get("diameter").toString();


          assertThat(name, is("Tatooine"));
          assertThat(statusCode, is(200));
          assertThat(name, equalTo("Tatooine"));

          assertThat(diameter, is("10465"));
          assertThat(diameter, equalTo("10465"));
    }

    @Test
    public void speciesTest() {

        Response response = given()
                .contentType(ContentType.XML)
                .accept(ContentType.JSON)
                .when()
                .request(Method.GET, "https://swapi.dev/api/species/1").then()
                .extract().response();

        System.out.println(response.getBody().prettyPrint());

        JSONObject json = new JSONObject(response.asString());
        System.out.println("json ===== "+ json);

        String name = json.get("name").toString();
        int statusCode = response.getStatusCode();
        String classification = json.get("classification").toString();

        assertThat(name, is("Human"));
        assertThat(statusCode, is(200));
        assertThat(name, equalTo("Human"));

        assertThat(classification, is("mammal"));
        assertThat(classification, equalTo("mammal"));
    }

    @Test
    public void filmTest() {

        Response response = given()
                .contentType(ContentType.XML)
                .accept(ContentType.JSON)
                .when()
                .request(Method.GET, "https://swapi.dev/api/films/1").then()
                .extract().response();

        System.out.println(response.getBody().prettyPrint());

        JSONObject json = new JSONObject(response.asString());
        System.out.println("json ===== "+ json);

        String title = json.get("title").toString();
        int statusCode = response.getStatusCode();
        String director = json.get("director").toString();

        assertThat(title, is("A New Hope"));
        assertThat(statusCode, is(200));
        assertThat(title, equalTo("A New Hope"));

        assertThat(director, is("George Lucas"));
        assertThat(director, equalTo("George Lucas"));
    }
}
