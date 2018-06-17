package ua.somedomen.osbb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ua.somedomen.osbb.service.CommentService;
import ua.somedomen.osbb.service.NewsService;
import ua.somedomen.osbb.service.StatusService;
import ua.somedomen.osbb.service.VotingService;


@Controller
public class DeleteController {

    @Autowired
    private NewsService newsService;

    @Autowired
    private VotingService votingService;

    @Autowired
    private StatusService statusService;

    @Autowired
    private CommentService commentService;

//    @GetMapping("/deleteNews")
//    public String deleteNews(
//            @RequestParam int id) {
//
//        newsService.delete(id);
//        return "redirect:/";
//    }
//
//    @GetMapping("/deleteVoting")
//    public String deleteVoting(
//            @RequestParam int id) {
//
//        votingService.delete(id);
//        return "redirect:/";
//    }
//
//    @GetMapping("/deleteStatus")
//    public String deleteStatus(
//            @RequestParam int id) {
//
//        statusService.delete(id);
//        return "redirect:/";
//    }
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
//        return "redirect:/";
//    }
}