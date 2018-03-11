package ua.somedomen.osbb.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.somedomen.osbb.entity.News;

public interface NewsDAO extends JpaRepository<News, Integer>{

//    @Query("from News n where n.newsName=:newsName")
//    News findByNewsName(@Param("newsName") String newsName);
}