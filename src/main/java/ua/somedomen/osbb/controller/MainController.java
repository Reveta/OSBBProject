package ua.somedomen.osbb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.somedomen.osbb.entity.News;
import ua.somedomen.osbb.entity.Voting;
import ua.somedomen.osbb.service.NewsService;
import ua.somedomen.osbb.service.VotingService;

import java.security.Principal;


@Controller
public class MainController {

    @Autowired
    private VotingService votingService;

    @Autowired
    private NewsService newsService;



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
}