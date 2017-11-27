package ua.somedomen.osbb.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.somedomen.osbb.entity.News;
import ua.somedomen.osbb.entity.securityEntity.User;
import ua.somedomen.osbb.service.NewsService;
import ua.somedomen.osbb.service.VotingService;
import ua.somedomen.osbb.service.securityService.UserService;

@Controller
public class EditingModelController {

    //В кабінеті має виводити інфорамцію. Зараз там стоять інпути з
    // можливістю редагування, але воно не працює толком. Хочу щоб
    // Сергій це глянув і точно пояснив, що за чим іде. Тереоично
    // ми не можемо увійти під Юзером. І через це нічого не виходить.

    @Autowired
    private VotingService votingService;

    @Autowired
    private NewsService newsService;

    @Autowired
    private UserService userService;


    public Object one;


    @PostMapping("/testUpdate")
    public String testUpdate(
            @RequestParam int newsId,
            @RequestParam String newsName,
            @RequestParam String newsText) {
        findById(newsId);

        News thisis;
        thisis = (News) one;

        thisis.setNewsName(newsName);
        thisis.setNewsText(newsText);
        newsService.save(thisis);

        return "redirect:/";
    }

    @PostMapping("/updatePersonalInfo")
    public String updatePersonalInfo(
            @RequestParam int id,
            @RequestParam String name,
            @RequestParam String prename,
            @RequestParam String email,
            @RequestParam String phoneNumber,
            @RequestParam String someInfo) {
        findById(id);

        User thisis;
        thisis = (User) one;

        thisis.setEmail(email);
        thisis.setName(name);
        thisis.setPrename(prename);
        thisis.setPhoneNumber(phoneNumber);
        thisis.setSomeInfo(someInfo);
        userService.save(thisis);

        return "redirect:/";
    }



    public void findById(int id){
            one = newsService.findOne(id);
    }


}
