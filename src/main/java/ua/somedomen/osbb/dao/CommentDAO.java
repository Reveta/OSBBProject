package ua.somedomen.osbb.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.somedomen.osbb.entity.Comments;

public interface CommentDAO extends JpaRepository<Comments, Integer> {
}
