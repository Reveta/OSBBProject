package ua.somedomen.osbb.service;

import ua.somedomen.osbb.entity.Voting;

import java.util.List;

public interface VotingService{

    void addVoting(Voting voting);

    List<Voting> findALL();

}
