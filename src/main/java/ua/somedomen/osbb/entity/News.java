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
    private String newsText;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "news", fetch = FetchType.EAGER)
    private List<Comments> newsComment = new ArrayList<>();

    public News(String newsName, String newsText, List<Comments> newsComment) {
        this.newsName = newsName;
        this.newsText = newsText;
        this.newsComment = newsComment;
    }

    public News(String newsName, String newsText) {
        this.newsName = newsName;
        this.newsText = newsText;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNewsName() {
        return newsName;
    }

    public String getNewsText() {
        return newsText;
    }

    public News(List<Comments> newsComment) {
        this.newsComment = newsComment;
    }

    public News() {
    }

    public void setNewsText(String newsText) {
        this.newsText = newsText;
    }

    public void setNewsName(String newsName) {
        this.newsName = newsName;
    }

    public List<Comments> getNewsComment() {
        return newsComment;
    }

    public void setNewsComment(List<Comments> newsComment) {
        this.newsComment = newsComment;
    }
}