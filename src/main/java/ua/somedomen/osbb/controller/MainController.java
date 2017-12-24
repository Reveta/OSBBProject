package ua.somedomen.osbb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.somedomen.osbb.entity.Comments;
import ua.somedomen.osbb.entity.News;
import ua.somedomen.osbb.entity.Status;
import ua.somedomen.osbb.entity.Voting;
import ua.somedomen.osbb.service.NewsService;
import ua.somedomen.osbb.service.StatusService;
import ua.somedomen.osbb.service.VotingService;

import java.util.Date;
import java.util.List;


@Controller
public class MainController{

    @Autowired
    private VotingService votingService;

    @Autowired
    private NewsService newsService;

    @Autowired
    private StatusService statusService;


    @PostMapping("/addNews")
    public String addNews(
            @RequestParam String newsName,
            @RequestParam String newsText){
        newsService.addNews(new News(newsName, newsText));

        return "redirect:/";
    }


    @PostMapping("/addVoting")
    public String addVoting(
            @RequestParam("votingName") String votingName,
            @RequestParam("votingText") String votingText){
        System.out.println(votingName);
        System.out.println(votingText);
        votingService.addVoting(new Voting(votingName, votingText));

        return "redirect:/";
    }

    @PostMapping("/addComment")
    public String addComment(
            @RequestParam int id,
            @RequestParam String commentValue
//            @RequestParam String userName
    ){
// Параметри авторизованого користувача, без Principal не вивести.

        News thisis = newsService.findOne(id);

            //Не зважайте на червоні методи, LomBok працює, все гаразд :)
            List<Comments> commentsList = thisis.getNewsComment();
            commentsList.add(new Comments(commentValue, String.valueOf(new Date()), thisis));

            thisis.setNewsName(thisis.getNewsName());
            thisis.setNewsText(thisis.getNewsText());
            thisis.setNewsComment(commentsList);
        newsService.save(thisis);

         return "redirect:/";
    }

    //Мапінг для статуса
    @PostMapping("/addStatus")
    public String addStatus(
            //Приймає два поля інформації
            @RequestParam String statusName,
            @RequestParam String statusText){

                //Зберегти(Створити) новий статус за допомогою наслідуваного метода з сервісРівня
        statusService.save(new Status(String.valueOf(new Date()), statusName, statusText));

        return "redirect:/";
    }
}