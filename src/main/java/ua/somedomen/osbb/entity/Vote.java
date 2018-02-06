package ua.somedomen.osbb.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Cascade;
import ua.somedomen.osbb.entity.securityEntity.User;


import javax.persistence.*;

@Entity
@Setter
@Getter
public class Vote{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Voting voteList;


    @ManyToOne(fetch = FetchType.EAGER)
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE,
            org.hibernate.annotations.CascadeType.REFRESH})
    private User user;

    private String vote;

    public Vote(Voting voteList, User user, String vote) {
        this.voteList = voteList;
        this.user = user;
        this.vote = vote;
    }

    public Vote() {
    }

    @Override
    public String toString() {
        return "Vote{" +
                ", vote='" + vote + '\'' +
                '}'+ '\n';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Voting getVoteList() {
        return voteList;
    }

    public void setVoteList(Voting voteList) {
        this.voteList = voteList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String isVote() {
        return vote;
    }

    public void setVote(String vote) {
        this.vote = vote;
    }
}
