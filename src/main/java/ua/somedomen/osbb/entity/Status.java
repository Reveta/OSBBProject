package ua.somedomen.osbb.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@ToString
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String statusTime;
    String statusName;
    String statusText;

    public Status(String statusTime, String statusName, String statusText) {
        this.statusTime = statusTime;
        this.statusName = statusName;
        this.statusText = statusText;
    }

    public Status() {
    }
}
