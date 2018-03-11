package ua.somedomen.osbb.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ua.somedomen.osbb.entity.Voting;

import java.util.ArrayList;
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

    private List<DTOActiveVoting> votingListDtoVoting;

    private int votingTrue;
    private int votingFalse;

    public DTOActiveVoting(int votingId, int votingStatus, String votingName, String votingShort, String votingText, String votingDate, List<DTOActiveVoting> votingListDtoVoting, int votingTrue, int votingFalse) {
        this.votingId = votingId;
        this.votingStatus = votingStatus;
        this.votingName = votingName;
        this.votingShort = votingShort;
        this.votingText = votingText;
        this.votingDate = votingDate;
        this.votingListDtoVoting = votingListDtoVoting;
        this.votingTrue = votingTrue;
        this.votingFalse = votingFalse;
    }

    public DTOActiveVoting(int votingStatus) {
        this.votingStatus = votingStatus;
    }

    public DTOActiveVoting() {
    }

    public static DTOActiveVoting createDTOAV(List<Voting> votingList, String username) {
        DTOActiveVoting dtoActiveVoting = new DTOActiveVoting();
        dtoActiveVoting.addStatus(votingList, username);
        Voting activeVoting = findActiveVoting(votingList);
        if (activeVoting != null) {
            dtoActiveVoting.resultVoting(activeVoting);
        }
        dtoActiveVoting.addDtoVotingList(votingList);

        return dtoActiveVoting;
    }

    private static Voting findActiveVoting(List<Voting> votingList) {
        for (Voting voting : votingList) {
            if (voting.isActiveStatus()) {
                return voting;
            }

        }
        return null;
    }


    private DTOActiveVoting addDtoVotingList(List<Voting> votingList) {
        List<DTOActiveVoting> votingListDtoVoting = new ArrayList<>();


        for (Voting voting : votingList) {
            DTOActiveVoting dtoVoting = new DTOActiveVoting();
            votingListDtoVoting.add(dtoVoting.resultVoting(voting));
        }

        this.setVotingListDtoVoting(votingListDtoVoting);

        return this;
    }

    private DTOActiveVoting resultVoting(Voting voting) {

        this.setVotingId(voting.getId());
        this.setVotingName(voting.getVotingName());
        this.setVotingShort(voting.getVotingShort());
        this.setVotingText(voting.getVotingText());
        this.setVotingDate(voting.getVotingTime());
        this.setVotingTrue(0 + voting.nuberOfTrue());
        this.setVotingFalse(0 + voting.nuberOfFalse());

        return this;
    }

    private DTOActiveVoting addStatus(List<Voting> votingList, String userName) {
        int status = 3;
        for (Voting voting : votingList) {
            if (voting.isActiveStatus()) {
                status = 2;

//            Оцей метод наповнює актуальне голосування
                if (!voting.wasVote(userName)) {
                    status = 1;
                }
            }
            this.setVotingStatus(status);
        }
        return this;
    }

}