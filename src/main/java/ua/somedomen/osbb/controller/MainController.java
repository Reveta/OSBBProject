package ua.somedomen.osbb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ua.somedomen.osbb.entity.Comments;
import ua.somedomen.osbb.entity.News;
import ua.somedomen.osbb.entity.Status;
import ua.somedomen.osbb.entity.Voting;
import ua.somedomen.osbb.service.NewsService;
import ua.somedomen.osbb.service.StatusService;
import ua.somedomen.osbb.service.VotingService;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.Date;
import java.util.List;



@Controller
public class MainController {

    @Autowired
    private VotingService votingService;

    @Autowired
    private NewsService newsService;

    @Autowired
    private StatusService statusService;



    @PostMapping("/addNews")
    public String addNews(
            @RequestParam String newsName,
            @RequestParam String newsShort,
            @RequestParam String newsAuthor,
            @RequestParam("newsbackscreen") MultipartFile multipartFile,
            @RequestParam String newsText){

        String path = System.getProperty("user.home") + File.separator + "projectOSBB"
                + File.separator +  "newsImages\\";

        try {
            multipartFile.transferTo(new File(path + multipartFile.getOriginalFilename()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        News news = new News(newsName, newsShort, newsText,
                /*Добавляю час створення новини*/String.valueOf(new Date()), newsAuthor);

        news.setBackscreen("\\newsImages\\" + multipartFile.getOriginalFilename());

        newsService.addNews(news);

        return "redirect:/";
    }

    @PostMapping("/addVoting")
    public String addVoting(
            @RequestParam String votingName,
            @RequestParam String votingShort,
            @RequestParam String votingText) {
        System.out.println(votingName);
        System.out.println(votingShort);
        System.out.println(votingText);

        votingService.save(new Voting(votingName, votingShort, votingText, String.valueOf(new Date()), 0, 0));

        return "redirect:/";
    }

    @PostMapping("/addTrue")
    public String addTrue(@RequestParam int id, HttpServletRequest request, Principal principal) {
        int value = Integer.parseInt(request.getParameter("count"));

//        Voting thisIS = votingService.findByVotingAndUserId(id, principal.getName());
        Voting thisIS = votingService.findOne(id);
        thisIS.setVotingTrue(value + 1);

        votingService.save(thisIS);

        return "redirect:/";
    }

    @PostMapping("/addFalse")
    public String addFalse(@RequestParam int id, HttpServletRequest request, Principal principal) {
        int value = Integer.parseInt(request.getParameter("count"));

//        Voting thisIS = votingService.findByVotingAndUserId(id, principal.getName());
        Voting thisIS = votingService.findOne(id);

        thisIS.setVotingFalse(value + 1);

        votingService.save(thisIS);

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
            @RequestParam String statusAuthor,
            @RequestParam String statusText){

        //Зберегти(Створити) новий статус за допомогою наслідуваного метода з сервісРівня
        statusService.save(new Status(String.valueOf(new Date()), statusName, statusText, statusAuthor));

        return "redirect:/";
    }
}