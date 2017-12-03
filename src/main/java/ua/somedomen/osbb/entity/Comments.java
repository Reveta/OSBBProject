package ua.somedomen.osbb.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.xml.ws.soap.MTOM;

@Entity
@Getter
@Setter
public class Comments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    private String commentValue;
    private String time;
    @ManyToOne
    private News news;


    public Comments(String commentValue, String time, News news) {
        this.commentValue = commentValue;
        this.time = time;
        this.news = news;
    }

    public Comments() {
    }


    @Override
    public String toString() {
        return "Comments{" +
                "id=" + id +
                ", commentValue='" + commentValue + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
