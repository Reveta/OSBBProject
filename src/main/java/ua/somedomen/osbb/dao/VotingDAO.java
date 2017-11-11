package ua.somedomen.osbb.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.somedomen.osbb.entity.Voting;

public interface VotingDAO extends JpaRepository<Voting, Integer> {
}
