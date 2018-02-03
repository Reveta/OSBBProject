package ua.somedomen.osbb.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ua.somedomen.osbb.entity.Voting;

import java.util.List;

@Setter
@Getter
@ToString
public class DTOActiveVoting {

    private int votingId;

//    status 1 - означає, що це голосування треба показати цьому юзеру
// так як воно активне і він за нього не голосував.
//    status 2 - означає, що це голосування активне, але юзер за нього
// вже голосував, показати його лише по кнопці.
//    status 3 - означає, що немає жодних активних голосувань.
    private int votingStatus;

    private String votingName;
    private String votingShort;
    private String votingText;
    private String votingDate;

    private List<DTOActiveVoting> votingListVote;

    private int votingTrue;
    private int votingFalse;

    public DTOActiveVoting(int votingId, int votingStatus, String votingName, String votingShort, String votingText, String votingDate, List<DTOActiveVoting> votingListVote, int votingTrue, int votingFalse) {
        this.votingId = votingId;
        this.votingStatus = votingStatus;
        this.votingName = votingName;
        this.votingShort = votingShort;
        this.votingText = votingText;
        this.votingDate = votingDate;
        this.votingListVote = votingListVote;
        this.votingTrue = votingTrue;
        this.votingFalse = votingFalse;
    }

    public DTOActiveVoting(int votingStatus) {
        this.votingStatus = votingStatus;
    }

    public DTOActiveVoting() {
    }

    public int getVotingId() {
        return votingId;
    }

    public DTOActiveVoting resultVoting(Voting voting){

        this.setVotingId(voting.getId());
        this.setVotingName(voting.getVotingName());
        this.setVotingShort(voting.getVotingShort());
        this.setVotingText(voting.getVotingText());
        this.setVotingDate(voting.getVotingTime());

        this.setVotingTrue(0 + voting.nuberOfTrue());
        this.setVotingFalse(0 + voting.nuberOfFalse());

        return this;
    }

    public void setVotingId(int votingId) {
        this.votingId = votingId;
    }

    public int getVotingStatus() {
        return votingStatus;
    }

    public void setVotingStatus(int votingStatus) {
        this.votingStatus = votingStatus;
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

    public String getVotingDate() {
        return votingDate;
    }

    public void setVotingDate(String votingDate) {
        this.votingDate = votingDate;
    }

    public List<DTOActiveVoting> getVotingListVote() {
        return votingListVote;
    }

    public void setVotingListVote(List<DTOActiveVoting> votingListVote) {
        this.votingListVote = votingListVote;
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
