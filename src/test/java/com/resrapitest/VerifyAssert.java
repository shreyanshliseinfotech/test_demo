package com.resrapitest;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

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

}
