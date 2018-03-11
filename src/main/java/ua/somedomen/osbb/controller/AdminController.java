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
import ua.somedomen.osbb.entity.securityEntity.User;
import ua.somedomen.osbb.service.NewsService;
import ua.somedomen.osbb.service.StatusService;
import ua.somedomen.osbb.service.UserService;
import ua.somedomen.osbb.service.VotingService;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.Date;
import java.util.List;



@Controller
public class AdminController {

    @Autowired
    private VotingService votingService;

    @Autowired
    private NewsService newsService;

    @Autowired
    private StatusService statusService;

    @Autowired
    private UserService userService;



    @PostMapping("/addNews")
    public String addNews(
            @RequestParam String newsName,
            @RequestParam String newsShort,
            @RequestParam String newsAuthor,
            @RequestParam("newsBackscreen") MultipartFile multipartFile,
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

        System.out.println("Створення новини" + newsName + "від "+ newsAuthor +
                ". Коротко - " + newsShort +"а, повно - " + newsText +". ");

        newsService.save(news);

        return "redirect:/";
    }

    @PostMapping("/addComment")
    public String addComment(
            @RequestParam int id,
            @RequestParam String commentValue,
            Principal principal
//            @RequestParam String userName
    ){
// Параметри авторизованого користувача, без Principal не вивести.

        News thisis = newsService.findOne(id);

        String userName = principal.getName();

        //Не зважайте на червоні методи, LomBok працює, все гаразд :)
        List<Comments> commentsList = thisis.getNewsComment();
        commentsList.add(new Comments(commentValue, String.valueOf(new Date()), userName, thisis));

        thisis.setNewsName(thisis.getNewsName());
        thisis.setNewsText(thisis.getNewsText());
        thisis.setNewsComment(commentsList);
        newsService.save(thisis);

//        System.out.println("Прокоментувано" + commentValue + "від "+ newsAuthor +
//                ". Коротко - " + newsShort +"а, повно - " + newsText +". ");

        return "redirect:/";
    }

    //Мапінг для статуса
    @PostMapping("/addStatus")
    public String addStatus(
            //Приймає два поля інформації
            @RequestParam String statusName,
            @RequestParam String statusAuthor,
            @RequestParam String statusText){
        System.out.println("Новий статус " + statusName + " від " + statusAuthor +
                ". Це: " + statusText +". ");

        //Зберегти(Створити) новий статус за допомогою наслідуваного метода з сервісРівня
        statusService.save(new Status(String.valueOf(new Date()), statusName, statusText, statusAuthor));

        return "redirect:/";
    }




    @PostMapping("/addVoting")
    public String addVoting(
            @RequestParam String votingName,
            @RequestParam String votingShort,
            @RequestParam String votingText) {

        System.out.println("Створення голосування за ім'ям "+ votingName + ". "
                + "Коротко "+ votingShort + "а також повно, " + votingText + ". ");

        Voting.disableVoting(votingService);

        votingService.save(new Voting(true ,votingName, votingShort,
                votingText, String.valueOf(new Date())));

        return "redirect:/";
    }

    @PostMapping("/newsUpdate")
    public String newsUpdate(
            @RequestParam int id,
            @RequestParam String newsName,
            @RequestParam String newsShort,
            @RequestParam String newsText) {

        News thisis = newsService.findOne(id);

        thisis.setNewsName(newsName);
        thisis.setNewsShort(newsShort);
        thisis.setNewsText(newsText);
        newsService.save(thisis);

        return "redirect:/admin";
    }

    @PostMapping("/statusUpdate")
    public String statusUpdate(
            @RequestParam int id,
            @RequestParam String statusName,
            @RequestParam String statusText) {

        Status thisis = statusService.findOne(id);

        //Не зважайте на червоні методи, LomBok працює, все гаразд :)
        thisis.setStatusName(statusName);
        thisis.setStatusText(statusText);
        statusService.save(thisis);

        return "redirect:/admin";
    }

    @PostMapping("/updatePersonalInfo")
    public String updatePersonalInfo(
            @RequestParam int id,
            @RequestParam String email,
            @RequestParam String name,
            @RequestParam String prename,
            @RequestParam String phoneNumber,
            @RequestParam String someInfo) {

        User thisis = userService.findOne(id);

        thisis.setEmail(email);
        thisis.setName(name);
        thisis.setPrename(prename);
        thisis.setPhoneNumber(phoneNumber);
        thisis.setSomeInfo(someInfo);
        userService.saveWithoutPassword(thisis);

        return "redirect:/";
    }

    @PostMapping("/votingUpdate")
    public String votingUpdate(
            @RequestParam int id,
            @RequestParam String votingName,
            @RequestParam String votingShort,
            @RequestParam String votingText) {
        System.out.println("\n \n \n"+id+" " + votingName+" " + votingShort+" " + votingText + "\n \n \n");

        Voting thisis = votingService.findOne(id);

        //Не зважайте на червоні методи, LomBok працює, все гаразд :)
        thisis.setVotingName(votingName);
        thisis.setVotingShort(votingShort);
        thisis.setVotingText(votingText);
        votingService.save(thisis);

        return "redirect:/admin";
    }


    @PostMapping("/deleteNews")
    public String deleteNews(
            @RequestParam int id) {

        newsService.delete(id);
        return "redirect:/admin";
    }

    //Голосування де вже голосували, не можна видалити
    @PostMapping("/deleteVoting")
    public String deleteVoting(
            @RequestParam int id) {
        Voting voting = votingService.findOne(id);
        voting.setVoteList(null);
        votingService.save(voting);

        votingService.delete(id);
        return "redirect:/admin";
    }

    @PostMapping("/deleteStatus")
    public String deleteStatus(
            @RequestParam int id) {

        statusService.delete(id);
        return "redirect:/admin";
    }

    @GetMapping("/disableVoting")
    public String disableVoting(){
        Voting.disableVoting(votingService);

        System.out.println("Всі голосування деактивовані");
        return "redirect:/";
    }
}