package com.restapitest;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@Data
public class Film {

    public int id;
    public String title;
    public int episode_id;
    public String opening_crawl;
    public String director;
    public String producer;
    public Date release_date;
}
