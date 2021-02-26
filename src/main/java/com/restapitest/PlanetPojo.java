package com.restapitest;
import lombok.*;

import java.util.ArrayList;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PlanetPojo {

        private String name;
        private String rotation_period;
        private String orbital_period;
        private String diameter;
        private String climate;
        private String gravity;
        private String terrain;
        private String surface_water;
        private String population;
        private ArrayList<String> residents;
        private ArrayList<String> films ;
        private String created;
        private String edited;
        private String url;

        @Override
        public String toString() {
                return "PlanetPojo{" +
                        "name='" + name + '\'' +
                        ", rotation_period='" + rotation_period + '\'' +
                        ", orbital_period='" + orbital_period + '\'' +
                        ", diameter='" + diameter + '\'' +
                        ", climate='" + climate + '\'' +
                        ", gravity='" + gravity + '\'' +
                        ", terrain='" + terrain + '\'' +
                        ", surface_water='" + surface_water + '\'' +
                        ", population='" + population + '\'' +
                        ", residents=" + residents +
                        ", films=" + films +
                        ", created='" + created + '\'' +
                        ", edited='" + edited + '\'' +
                        ", url='" + url + '\'' +
                        '}';
        }
}
