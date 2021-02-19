package com.resrapitest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.*;
import com.restapitest.FilmPojo;
import com.restapitest.People;
import com.restapitest.PeoplePojo;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class DeserializationWithGenericsTest {

    @Test
    public void test_people() throws IOException {

        String json_dir = "src/main/java/com/restapitest/people.json";
        System.out.println(json_dir);

        ObjectMapper mapper = new ObjectMapper();
        PeoplePojo model = mapper.readValue(new File(json_dir), PeoplePojo.class);

        String url = "https://swapi.dev/api/people/1";

        PeoplePojo people = RestAssured
                .given().get(url).as(PeoplePojo.class);
        System.out.println("People ====== "+ people.toString());
    }

    @Test
    public void test_film() throws IOException {

        String json_dir = "src/main/java/com/restapitest/film.json";
        System.out.println(json_dir);

        ObjectMapper mapper = new ObjectMapper();
        FilmPojo model = mapper.readValue(new File(json_dir), FilmPojo.class);

        String url = "https://swapi.dev/api/films/1";

        FilmPojo film = RestAssured
                .given().get(url).as(FilmPojo.class);
        System.out.println("====== "+ film.toString());
    }

}
