package ua.somedomen.osbb.service;

import ua.somedomen.osbb.entity.News;

import java.util.List;

public interface NewsService {

    void addNews(News news);

//    void addNewsComment(News news);

    List<News> findALL();
}
