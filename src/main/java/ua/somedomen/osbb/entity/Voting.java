package ua.somedomen.osbb.entity;


import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.userdetails.UserDetails;
import ua.somedomen.osbb.entity.securityEntity.User;
import ua.somedomen.osbb.service.VoteService;
import ua.somedomen.osbb.entity.Voting;
import ua.somedomen.osbb.service.VotingService;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Setter
@Getter
public class Voting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private boolean activeStatus;
    private String votingName = "Ваше звичайне голосування";
    private String votingShort = "Програмісти також люди";
    private String votingText = "Подайте на хліб";
    private String votingTime;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "voteList")
    private List<Vote> voteList;

    public Voting(boolean activeStatus, String votingName, String votingShort, String votingText, String votingTime) {
        this.activeStatus = activeStatus;
        this.votingName = votingName;
        this.votingShort = votingShort;
        this.votingText = votingText;
        this.votingTime = votingTime;
    }

    public Voting() {
    }

    public int nuberOfTrue() {
        int sum = 0;
        List<Vote> voteList = this.voteList;
        for (Vote vote : voteList) {
            if (vote.isVote().equals("true")) {
                sum++;
            }
        }
        return sum;
    }

    public int nuberOfFalse() {
        int sum = 0;
        List<Vote> voteList = this.voteList;
        for (Vote vote : voteList) {
            if (vote.isVote().equals("false")) {
                sum++;
            }
        }
        return sum;
    }

    public boolean wasVote(String principal) {
        boolean status = false;
        List<Vote> voteList = this.voteList;
        for (Vote vote: voteList) {
            System.out.println(principal);
            String username = vote.getUser().getUsername();
            System.out.println(username);
            if (principal.equals(username)){
                status = true;
            }
        }
        System.out.println(status);
        return status;
    }

    public static void disableVoting(VotingService votingService){

        List<Voting> votingList = votingService.findALL();
        for (Voting voting: votingList) {
            if(voting.isActiveStatus() == true) {
                voting.setActiveStatus(false);
                votingService.save(voting);
            }
        }
    }


    @Override
    public String toString() {
        return "Voting{" +
                "id=" + id +
                ", votingName='" + votingName + '\'' +
                ", votingShort='" + votingShort + '\'' +
                ", votingText='" + votingText + '\'' +
                ", votingTime='" + votingTime + '\'' +
                '}' + '\n';
    }

    public List<Vote> getVoteList() {
        return voteList;
    }

    public void setVoteList(List<Vote> voteList) {
        this.voteList = voteList;
    }
}
