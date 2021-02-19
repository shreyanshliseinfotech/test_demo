package com.resrapitest;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
public class VerifyAssert {

    @Test
    public void textAsset(){

        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        given().get("/users/1").then().assertThat()
                .body("name", equalTo("Leanne Graham"))
                .and()
                .body("address.city", equalTo("Gwenborough"))
                .and()
                .body("address.geo.lng", is("81.1496"))
                .and()
                .body("company.catchPhrase", equalTo("Multi-layered client-server neural-net"));
    }

    @Test
    public void textAssetThat(){

        String name, city, lng, catchPhrase;

        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

            Response response = given().get("/users/1");
            name = JsonPath.from(response.getBody().asString()).get("name");

            city = JsonPath.from(response.getBody().asString()).get("address.city");

            lng = JsonPath.from(response.getBody().asString()).get("address.geo.lng");

            catchPhrase = JsonPath.from(response.getBody().asString()).get("company.catchPhrase");

            assertThat((new Object[]{name, city, lng, catchPhrase}), is(new Object[]{"Leanne Graham", "Gwenborough", "81.1496", "Multi-layered client-server neural-net"}));
    }

    @Test
    public void textAssetThatWithList(){

        List<String> name, city, lng, catchPhrase;

        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        Response response = given().get("/users");

        name = new ArrayList<String>();
        name = JsonPath.from(response.getBody().asString()).get("name");

        city = new ArrayList<String>();
        city = JsonPath.from(response.getBody().asString()).get("address.city");

        lng = new ArrayList<String>();
        lng = JsonPath.from(response.getBody().asString()).get("address.geo.lng");

        catchPhrase = new ArrayList<String>();
        catchPhrase = JsonPath.from(response.getBody().asString()).get("company.catchPhrase");

        assertThat((new Object[]{name.get(0), city.get(0), lng.get(0), catchPhrase.get(0),
                        name.get(1), city.get(1), lng.get(1), catchPhrase.get(1),
                        name.get(2), city.get(2), lng.get(2), catchPhrase.get(2),
                        name.get(3), city.get(3), lng.get(3), catchPhrase.get(3),
                        name.get(4), city.get(4), lng.get(4), catchPhrase.get(4)}),
                is(new Object[]{"Leanne Graham", "Gwenborough", "81.1496", "Multi-layered client-server neural-net",
                        "Ervin Howell", "Wisokyburgh", "-34.4618", "Proactive didactic contingency",
                        "Clementine Bauch", "McKenziehaven", "-47.0653", "Face to face bifurcated interface",
                        "Patricia Lebsack", "South Elvis", "-164.2990", "Multi-tiered zero tolerance productivity",
                        "Chelsey Dietrich", "Roscoeview", "62.5342", "User-centric fault-tolerant solution"}));
    }

}
