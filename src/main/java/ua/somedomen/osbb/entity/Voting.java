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
    private String votingShort;
    private String votingText;
    private String votingTime;

    private int votingTrue;
    private int votingFalse;


    public Voting(String votingName, String votingShort, String votingText, String votingTime, int votingTrue, int votingFalse) {
        this.votingName = votingName;
        this.votingShort = votingShort;
        this.votingText = votingText;
        this.votingTime = votingTime;
        this.votingTrue = votingTrue;
        this.votingFalse = votingFalse;
    }

    public Voting() {
    }

    public int getVotingTrue() {
        return votingTrue;
    }

    public void setVotingTrue(int votingTrue) {
        this.votingTrue = votingTrue;
    }

    public int getVotingFalse() {
        return votingFalse;
    }

    public void setVotingFalse(int votingFalse) {
        this.votingFalse = votingFalse;
    }
}

