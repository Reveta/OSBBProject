package ua.somedomen.osbb.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@ToString
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String newsName;
    private String newsShort;
    private String newsText;
    private String newsTime;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "news", fetch = FetchType.EAGER)
    private List<Comments> newsComment = new ArrayList<>();

    public News(String newsName, String newsShort, String newsText, String newsTime, List<Comments> newsComment) {
        this.newsName = newsName;
        this.newsShort = newsShort;
        this.newsText = newsText;
        this.newsTime = newsTime;
        this.newsComment = newsComment;
    }

    public News(String newsName, String newsShort, String newsText, String newsTime) {
        this.newsName = newsName;
        this.newsShort = newsShort;
        this.newsText = newsText;
        this.newsTime = newsTime;
    }

    public News() {
    }
}
