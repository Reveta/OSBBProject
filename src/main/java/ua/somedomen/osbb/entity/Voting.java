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
public class Voting{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String votingName;
    private String votingText;
//    private String url;


    public Voting(String votingName, String votingText) {
        this.votingName = votingName;
        this.votingText = votingText;
    }

    public Voting() {
    }
}
