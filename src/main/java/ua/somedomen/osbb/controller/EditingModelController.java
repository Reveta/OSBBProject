package ua.somedomen.osbb.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.somedomen.osbb.entity.News;
import ua.somedomen.osbb.entity.Status;
import ua.somedomen.osbb.entity.Voting;
import ua.somedomen.osbb.entity.securityEntity.User;
import ua.somedomen.osbb.service.NewsService;
import ua.somedomen.osbb.service.StatusService;
import ua.somedomen.osbb.service.UserService;
import ua.somedomen.osbb.service.VotingService;

@Controller
public class EditingModelController {

    @Autowired
    private VotingService votingService;

    @Autowired
    private NewsService newsService;

    @Autowired
    private UserService userService;

    @Autowired
    private StatusService statusService;



//
//    @GetMapping("/deleteComment")
//    public String deleteComment(
//            @RequestParam int newsId,
//            @RequestParam int commentId) {
//        //не працює видалення коментарів
//
////        News thisis = newsService.findOne(newsId);
////
////        //Не зважайте на червоні методи, LomBok працює, все гаразд :)
////        List<Comments> commentsList = thisis.getNewsComment();
////        commentsList.remove(commentId);
////
////        thisis.setNewsName(thisis.getNewsName());
////        thisis.setNewsText(thisis.getNewsText());
////        thisis.setNewsComment(commentsList);
////        newsService.save(thisis);
//
////        commentService.delete(commentId);
//        return "redirect:/admin";
//    }

}