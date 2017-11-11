package ua.somedomen.osbb.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Setter
@Getter
@ToString
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String newsName;
    private String newsText;
    private String newsComment;

    public News(String newsName, String newsText, String newsComment) {
        this.newsName = newsName;
        this.newsText = newsText;
        this.newsComment = newsComment;
    }

    public News(String newsName, String newsText) {
        this.newsName = newsName;
        this.newsText = newsText;
    }

    public News() {
    }
}
