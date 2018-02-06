package ua.somedomen.osbb.service;

import ua.somedomen.osbb.entity.Vote;
import ua.somedomen.osbb.entity.Voting;

import java.util.List;

public interface VoteService {

    Vote save(Vote Vote);

    List<Vote> findALL();

    Vote findOne(int voteId);

    void delete(int id);
}
