package ua.somedomen.osbb.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.somedomen.osbb.entity.Voting;

public interface VotingDAO extends JpaRepository<Voting, Integer> {

//    @Query("select v.id from Voting v, User u where v.id=:id and u.username=:username")
//    Voting findByVotingAndUserId(@Param("id") int id, @Param("username") String username);
}