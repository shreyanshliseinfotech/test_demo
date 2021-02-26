package com.resrapitest;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.restapitest.People;
import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import org.junit.jupiter.api.Test;
import org.testng.annotations.TestInstance;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class TestJsonToJava {

    @Test
    public void test_case(){
//        String base_dir = System.getProperty("user.dir");
        String json_dir = "src/main/java/com/restapitest/people.json";
        System.out.println(json_dir);

        ObjectMapper mapper = new ObjectMapper();

        try{
            People stu = mapper.readValue(new File(json_dir), People.class);
            System.out.println("Id = " + stu.getId() + " || " + "Name = " + stu.getName() +
                    " || " + "Height = " + stu.getHeight() + " || " + "mass = " + stu.getMass()
                    + " || " + "Hair_Color = " + stu.getHair_color()
                    + " || " + "skin_color = " + stu.getSkin_color()
                    + " || " + "eye_color = " + stu.getEye_color()
                    + " || " + "birth_year = " + stu.getBirth_year()
                    + " || " + "gender = " + stu.getGender()
//                    + " || \n" + "Title = " + stu.getFilms().get(0).getTitle()
//                    + " || " + "Episode_id = " + stu.getFilms().get(0).getEpisode_id()
//                    + " || " + "Opening_crawl = " + stu.getFilms().get(0).getOpening_crawl()
//                    + " || " + "Director = " + stu.getFilms().get(0).getDirector()
//                    + " || " + "Producer = " + stu.getFilms().get(0).getProducer()
//                    + " || " + "Release_date = " + stu.getFilms().get(0).getRelease_date()
                      );

        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
