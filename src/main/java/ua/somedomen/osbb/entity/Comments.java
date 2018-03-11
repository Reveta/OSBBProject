package ua.somedomen.osbb.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
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
    private String userName;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private News news;


    public Comments(String commentValue, String time, String userName, News news) {
        this.commentValue = commentValue;
        this.time = time;
        this.userName = userName;
        this.news = news;
    }

    public Comments(String commentValue, String time, News news) {
        this.commentValue = commentValue;
        this.time = time;
        this.news = news;
    }

    public Comments(String commentValue, String time) {
        this.commentValue = commentValue;
        this.time = time;
    }



    public Comments() {
    }

    @Override
    public String toString() {
        return "Comments{" +
                "id=" + id +
                ", commentValue='" + commentValue + '\'' +
                ", time='" + time + '\'' +
                ", userName='" + userName + '\'' +
                '}'+ '\n';
    }
}
