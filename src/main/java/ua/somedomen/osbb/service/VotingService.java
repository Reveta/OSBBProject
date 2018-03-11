package ua.somedomen.osbb.service;

import ua.somedomen.osbb.entity.Voting;

import java.util.List;

public interface VotingService{

    Voting save(Voting voting);

    List<Voting> findALL();

    Voting findOne(int votingId);

//    Voting findByVotingAndUserId(int id, String username);

    void delete(int id);
}