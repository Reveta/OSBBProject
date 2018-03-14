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
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String newsName;
    private String newsShort;
    private String newsText;
    private String newsTime;
    private String newsAuthor;

    private String backscreen;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "news", fetch = FetchType.EAGER)
    private List<Comments> newsComment = new ArrayList<>();

    public News(String newsName, String newsShort, String newsText, String newsTime, List<Comments> newsComment) {
        this.newsName = newsName;
        this.newsShort = newsShort;
        this.newsText = newsText;
        this.newsTime = newsTime;
        this.newsComment = newsComment;
    }

    public News(String newsName, String newsShort, String newsText, String newsTime, String newsAuthor) {
        this.newsName = newsName;
        this.newsShort = newsShort;
        this.newsText = newsText;
        this.newsTime = newsTime;
        this.newsAuthor = newsAuthor;
    }

    public News() {
    }

    public static int getIdFromURL(News lastNews){
        return lastNews.getId();
    }

    public static News getLastNews(List<News> newsListFull){
        return (newsListFull.get(newsListFull.size() - 1));
    }

    public static List<News> getThreeLastNews(List<News> newsListFull){
        List<News> threeLastNews = new ArrayList<>();
        threeLastNews.add(newsListFull.get(newsListFull.size() - 1));
        threeLastNews.add(newsListFull.get(newsListFull.size() - 2));
        threeLastNews.add(newsListFull.get(newsListFull.size() - 3));

        return threeLastNews;
    }

    public String getBackscreen() {
        return backscreen;
    }

    public void setBackscreen(String backscreen) {
        this.backscreen = backscreen;
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", newsName='" + newsName + '\'' +
                ", newsShort='" + newsShort + '\'' +
                ", newsText='" + newsText + '\'' +
                ", newsTime='" + newsTime + '\'' +
                '}'+ '\n';
    }
}