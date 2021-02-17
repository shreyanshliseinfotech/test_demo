package com.restapitest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class testJsonToJava {

    private String cour;

    @Test
    public void test(){
//        String base_dir = System.getProperty("user.dir");
        String json_dir = "src/main/java/com/restapitest/demo.json";
        System.out.println(json_dir);

        ObjectMapper mapper = new ObjectMapper();

        try{
            Student stu = mapper.readValue(new File(json_dir), Student.class);
            System.out.println("Id = " + stu.getId() + " || " + "Name = " + stu.getName() +
                    " || " + "Height = " + stu.getHeight() + " || " + "mass = " + stu.getMass()
                    + " || " + "Hair_Color = " + stu.getHair_color()
                    + " || " + "skin_color = " + stu.getSkin_color()
                    + " || " + "eye_color = " + stu.getEye_color()
                    + " || " + "birth_year = " + stu.getBirth_year()
                    + " || " + "gender = " + stu.getGender()
                    + " || \n" + "Title = " + stu.getFilms().get(0).getTitle()
                    + " || " + "Episode_id = " + stu.getFilms().get(0).getEpisode_id()
                    + " || " + "Opening_crawl = " + stu.getFilms().get(0).getOpening_crawl()
                    + " || " + "Director = " + stu.getFilms().get(0).getDirector()
                    + " || " + "Producer = " + stu.getFilms().get(0).getProducer()
                    + " || " + "Release_date = " + stu.getFilms().get(0).getRelease_date());

        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
