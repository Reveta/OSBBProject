package ua.somedomen.osbb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.somedomen.osbb.dao.NewsDAO;
import ua.somedomen.osbb.entity.News;
import ua.somedomen.osbb.service.NewsService;

import java.util.List;

@Service
@Transactional
public class NewsServiceImpl implements NewsService{

    @Autowired
    private NewsDAO newsDAO;

    @Override
    public List<News> findALL() {
        return newsDAO.findAll();
    }

    @Override
    public News findOne(int id) {
        return  newsDAO.findOne(id);
    }

    @Override
    public News save(News news) {
        return newsDAO.save(news);
    }

    @Override
    public void delete(int id) {
        newsDAO.delete(id);
    }
}