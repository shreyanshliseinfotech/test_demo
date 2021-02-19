package com.restapitest;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FilmPojo {

        private String title;
        private Integer episode_id;
        private String opening_crawl;
        private String director;
        private String producer;
        private String release_date;
        private ArrayList<String> characters;
        private ArrayList<String> planets;
        private ArrayList<String> starships;
        private ArrayList<String> vehicles;
        private ArrayList<String> species;
        private String created;
        private String edited;
        private String url;

    @Override
    public String toString() {
        return "FilmPojo{" +
                "title='" + title + '\'' +
                ", episode_id=" + episode_id +
                ", opening_crawl='" + opening_crawl + '\'' +
                ", director='" + director + '\'' +
                ", producer='" + producer + '\'' +
                ", release_date='" + release_date + '\'' +
                ", characters=" + characters +
                ", planets=" + planets +
                ", starships=" + starships +
                ", vehicles=" + vehicles +
                ", species=" + species +
                ", created='" + created + '\'' +
                ", edited='" + edited + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}