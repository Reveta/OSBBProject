package ua.somedomen.osbb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.somedomen.osbb.dao.CommentDAO;
import ua.somedomen.osbb.entity.Comments;
import ua.somedomen.osbb.service.CommentService;

import java.util.List;

@Service
@Transactional
public class CommentServiceImpl implements CommentService{

    @Autowired
    private CommentDAO commentDAO;

    @Override
    public List<Comments> findALL() {
        return commentDAO.findAll();
    }

    @Override
    public Comments findOne(int id) {
        return commentDAO.findById(id);
    }

    @Override
    public Comments save(Comments comments) {
        return commentDAO.save(comments);
    }

    @Override
    public void delete(int id) {
        commentDAO.delete(id);
    }
}