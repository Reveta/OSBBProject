package ua.somedomen.osbb.service;

import ua.somedomen.osbb.entity.Comments;
import java.util.List;


public interface CommentService {


    List<Comments> findALL();

    Comments findOne(int id);

    Comments save(Comments comments);
}