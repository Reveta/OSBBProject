package ua.somedomen.osbb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.somedomen.osbb.dao.VoteDAO;
import ua.somedomen.osbb.entity.Vote;
import ua.somedomen.osbb.entity.Voting;
import ua.somedomen.osbb.service.VoteService;

import java.util.List;

@Service
@Transactional
public class VoteServiceImpl implements VoteService {

    @Autowired
    private VoteDAO voteDAO;


    @Override
    public Vote save(Vote vote) {
        return voteDAO.save(vote);
    }

    @Override
    public List<Vote> findALL() {
        return voteDAO.findAll();
    }

    @Override
    public Vote findOne(int voteId) {
        return voteDAO.findOne(voteId);
    }

    @Override
    public void delete(int id) {
    }
}
