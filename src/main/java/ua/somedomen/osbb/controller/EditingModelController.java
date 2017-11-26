package ua.somedomen.osbb.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.somedomen.osbb.entity.News;
import ua.somedomen.osbb.service.NewsService;
import ua.somedomen.osbb.service.VotingService;

@Controller
public class EditingModelController {

    @Autowired
    private VotingService votingService;

    @Autowired
    private NewsService newsService;



    @PostMapping("/testUpdate")
    public String testUpdate(
            @RequestParam int newsId,
            @RequestParam String newsName) {
        News one = newsService.findOne(newsId);
        one.setNewsName(newsName);
        newsService.save(one);

        return "redirect:/";
    }

}
