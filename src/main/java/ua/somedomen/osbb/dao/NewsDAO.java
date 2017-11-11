package ua.somedomen.osbb.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.somedomen.osbb.entity.News;

public interface NewsDAO extends JpaRepository<News, Integer>{
}
