package com.resrapitest;

import com.restapitest.FilmPojo;
import com.restapitest.PlanetPojo;
import com.restapitest.SpeciesPojo;
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

        PlanetPojo planet = response.as(PlanetPojo.class);
        System.out.println("planet :"+ planet);

          System.out.println(response.getBody().prettyPrint());

          assertThat(planet.getName(), is("Tatooine"));
          assertThat(planet.getName(), equalTo("Tatooine"));

          assertThat(planet.getPopulation(), is("200000"));
          assertThat(planet.getPopulation(), equalTo("200000"));

          assertThat(planet.getDiameter(), is("10465"));
          assertThat(planet.getDiameter(), equalTo("10465"));

    }

    @Test
    public void speciesTest() {

        Response response = given()
                .contentType(ContentType.XML)
                .accept(ContentType.JSON)
                .when()
                .request(Method.GET, "https://swapi.dev/api/species/1").then()
                .extract().response();

        SpeciesPojo species = response.as(SpeciesPojo.class);
        System.out.println("species :"+ species);

        System.out.println(response.getBody().prettyPrint());

        assertThat(species.getName(), is("Human"));
        assertThat(species.getName(), equalTo("Human"));

        assertThat(species.getClassification(), is("mammal"));
        assertThat(species.getClassification(), equalTo("mammal"));

        assertThat(species.getDesignation(), is("sentient"));
        assertThat(species.getDesignation(), equalTo("sentient"));

    }

    @Test
    public void filmTest() {

        Response response = given()
                .contentType(ContentType.XML)
                .accept(ContentType.JSON)
                .when()
                .request(Method.GET, "https://swapi.dev/api/films/1").then()
                .extract().response();

        FilmPojo film = response.as(FilmPojo.class);
        System.out.println("film :"+ film);

        System.out.println(response.getBody().prettyPrint());

        assertThat(film.getTitle(), is("A New Hope"));
        assertThat(film.getTitle(), equalTo("A New Hope"));

        assertThat(film.getDirector(), is("George Lucas"));
        assertThat(film.getDirector(), equalTo("George Lucas"));

        assertThat(film.getRelease_date(), is("1977-05-25"));
        assertThat(film.getRelease_date(), equalTo("1977-05-25"));

    }
}
