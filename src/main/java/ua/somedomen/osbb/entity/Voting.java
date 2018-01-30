package ua.somedomen.osbb.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Setter
@Getter
public class Voting{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private boolean status;
    private String votingName = "Ваше звичайне голосування";
    private String votingShort = "Програмісти також люди";
    private String votingText = "Подайте на хліб";
    private String votingTime;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "voteList")
    private List<Vote> voteList;

    public Voting(boolean status, String votingName, String votingShort, String votingText, String votingTime) {
        this.status = status;
        this.votingName = votingName;
        this.votingShort = votingShort;
        this.votingText = votingText;
        this.votingTime = votingTime;
    }

    public Voting() {
    }

    @Override
    public String toString() {
        return "Voting{" +
                "id=" + id +
                ", votingName='" + votingName + '\'' +
                ", votingShort='" + votingShort + '\'' +
                ", votingText='" + votingText + '\'' +
                ", votingTime='" + votingTime + '\'' +
                '}';
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVotingName() {
        return votingName;
    }

    public void setVotingName(String votingName) {
        this.votingName = votingName;
    }

    public String getVotingShort() {
        return votingShort;
    }

    public void setVotingShort(String votingShort) {
        this.votingShort = votingShort;
    }

    public String getVotingText() {
        return votingText;
    }

    public void setVotingText(String votingText) {
        this.votingText = votingText;
    }

    public String getVotingTime() {
        return votingTime;
    }

    public void setVotingTime(String votingTime) {
        this.votingTime = votingTime;
    }

    public List<Vote> getVoteList() {
        return voteList;
    }

    public void setVoteList(List<Vote> voteList) {
        this.voteList = voteList;
    }
}

