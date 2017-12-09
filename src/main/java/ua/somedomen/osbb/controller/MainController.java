package ua.somedomen.osbb.controller;

import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.somedomen.osbb.entity.Comments;
import ua.somedomen.osbb.entity.News;
import ua.somedomen.osbb.entity.Voting;
import ua.somedomen.osbb.service.CommentService;
import ua.somedomen.osbb.service.NewsService;
import ua.somedomen.osbb.service.VotingService;

import javax.xml.crypto.Data;
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
    private CommentService commentService;


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
// Параметри авторизованого користувача, без Principal їх не вивести.

        News thisis = newsService.findOne(id);

        List<Comments> commentsList = thisis.getNewsComment();
        commentsList.add(new Comments(commentValue, String.valueOf(new Date()), thisis));

        thisis.setNewsName(thisis.getNewsName());
        thisis.setNewsText(thisis.getNewsText());
        thisis.setNewsComment(commentsList);

        newsService.save(thisis);

//        System.out.println(id + commentValue);

         return "redirect:/";
    }
}