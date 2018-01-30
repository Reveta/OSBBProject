package ua.somedomen.osbb.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.somedomen.osbb.entity.Vote;

public interface VoteDAO extends JpaRepository<Vote, Integer> {
}
