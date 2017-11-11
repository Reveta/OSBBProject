package ua.somedomen.osbb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.somedomen.osbb.dao.VotingDAO;
import ua.somedomen.osbb.entity.Voting;
import ua.somedomen.osbb.service.VotingService;

import java.util.List;

@Service
@Transactional
public class VotingServiceImpl implements VotingService {

    @Autowired
    private VotingDAO votingDAO;

    @Override
    public void addVoting(Voting voting)
    {
        votingDAO.save(voting);
    }

    @Override
    public List<Voting> findALL() {
        return votingDAO.findAll();
    }
}
