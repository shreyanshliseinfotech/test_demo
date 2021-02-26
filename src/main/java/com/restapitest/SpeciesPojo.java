package com.restapitest;
import lombok.*;

import java.util.ArrayList;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SpeciesPojo {

        private String name;
        private String classification;
        private String designation;
        private String average_height;
        private String skin_colors;
        private String hair_colors;
        private String eye_colors;
        private String average_lifespan;
        private String homeworld;
        private String language;
        private ArrayList<String> people;
        private ArrayList<String> films;
        private String created;
        private String edited;
        private String url;

        @Override
        public String toString() {
                return "SpeciesPojo{" +
                        "name='" + name + '\'' +
                        ", classification='" + classification + '\'' +
                        ", designation='" + designation + '\'' +
                        ", average_height='" + average_height + '\'' +
                        ", skin_colors='" + skin_colors + '\'' +
                        ", hair_colors='" + hair_colors + '\'' +
                        ", eye_colors='" + eye_colors + '\'' +
                        ", average_lifespan='" + average_lifespan + '\'' +
                        ", homeworld='" + homeworld + '\'' +
                        ", language='" + language + '\'' +
                        ", people=" + people +
                        ", films=" + films +
                        ", created='" + created + '\'' +
                        ", edited='" + edited + '\'' +
                        ", url='" + url + '\'' +
                        '}';
        }
}
