package ua.somedomen.osbb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ua.somedomen.osbb.service.NewsService;
import ua.somedomen.osbb.service.VotingService;

import java.security.Principal;

@Controller
public class PagesController {

    @Autowired
    private VotingService votingService;

    @Autowired
    private NewsService newsService;


    @GetMapping("/")
    public String index(Model model) {
//        model.addAttribute("URL", new ListURL());
//        model.addAttribute("ABC", qwe);
        model.addAttribute("votingShowAll", votingService.findALL());
        model.addAttribute("newsShowAll", newsService.findALL());
        return "index";
    }

    @GetMapping("/admin")
    public String loginAdm(Principal principal, Model model) {
        model.addAttribute("user", principal);
        return "admin";
    }

    @GetMapping("/login")
    public String indexLogin() {
        return "login";
    }

    @GetMapping("/logout")
    public String logout() {
        return "index";
    }


    @GetMapping("/cabinet")
    public String cabinet() {
        return "cabinet";
    }

}
