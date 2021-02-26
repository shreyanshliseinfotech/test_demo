package com.resrapitest;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.restapitest.FilmPojo;
import com.restapitest.PeoplePojo;
import com.restapitest.PlanetPojo;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class SwApiTest1 {

    @Test
    public void planetTest1() throws JsonProcessingException {

        Response response = given()
                //.contentType(ContentType.XML)
                .accept(ContentType.JSON)
                .when()
                .request(Method.GET, "https://swapi.dev/api/planets/1").then()
                .extract().response();
        System.out.println(response.asString());
        System.out.println("=========================");

        JSONObject json = new JSONObject(response.asString());
        System.out.println("json ===== "+ json);

        JSONArray jsonarray = json.getJSONArray("residents");
        System.out.println("=====11 "+ jsonarray);
        JSONArray jsonData2 = json.getJSONArray("films");
        System.out.println("=====22 "+ jsonData2);

        ObjectMapper jsonMapper = new ObjectMapper();
        try
        {
            PlanetPojo node = jsonMapper.readValue(json.toString(), PlanetPojo.class);
            System.out.println("====== "+ node);

        }
        catch (JsonGenerationException e)
        {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

//    @Test
//    public void planetTest1() throws IOException {
//        String json_dir = "src/main/java/com/restapitest/people.json";
//        System.out.println(json_dir);
//
//        ObjectMapper jsonMapper = new ObjectMapper();
//
//        PlanetPojo node = jsonMapper.readValue(new File(json_dir), PlanetPojo.class);
//
//        System.out.println("====== "+ node);
//
//
//    }
}
