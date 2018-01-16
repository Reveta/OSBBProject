package ua.somedomen.osbb.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.somedomen.osbb.entity.Comments;

public interface CommentDAO extends JpaRepository<Comments, Integer> {

    @Query("from Comments c where c.id=:id")
    Comments findById(@Param("id") int id);
}
