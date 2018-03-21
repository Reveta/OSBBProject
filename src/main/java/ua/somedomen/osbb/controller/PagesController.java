package ua.somedomen.osbb.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.somedomen.osbb.dto.DTOActiveVoting;
import ua.somedomen.osbb.entity.Comments;
import ua.somedomen.osbb.entity.News;
import ua.somedomen.osbb.entity.Voting;
import ua.somedomen.osbb.entity.securityEntity.User;
import ua.somedomen.osbb.service.CommentService;
import ua.somedomen.osbb.service.NewsService;
import ua.somedomen.osbb.service.StatusService;
import ua.somedomen.osbb.service.UserService;
import ua.somedomen.osbb.service.VoteService;
import ua.somedomen.osbb.service.VotingService;
import ua.somedomen.osbb.validator.UserValidator;


@Controller
public class PagesController {

  @Autowired
  private UserService userService;

  @Autowired
  private UserValidator userValidator;

  @Autowired
  private VotingService votingService;

  @Autowired
  private VoteService voteService;

  @Autowired
  private NewsService newsService;

  @Autowired
  private StatusService statusService;

  @Autowired
  private CommentService commentService;

  int futureNewsId = 42; // заглушка для newsId. Треба коли сервак стартує перший раз

  @GetMapping("/")
  public String index(Model model, Principal principal) {
    Object principalO = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    String userName = principalO instanceof UserDetails ? principal.getName() : "adminqweewq";

    UserDetails byUsername = userService.loadUserByUsername(userName);
    List<News> newsListFull = newsService.findALL(); // Оцей метод наповнює ліст голосувань
    List<Voting> votingList = votingService.findALL();
    System.out.println(newsListFull);
    DTOActiveVoting dtoActiveVoting = DTOActiveVoting.createDTOAV(votingList, userName);

    ///
    News newsLast = newsListFull.get(newsListFull.size() - 1);
    List<Comments> lastComments = newsLast.getNewsComment();
    List<News> threeLastNews = new ArrayList<>();
    int countOfComments = newsLast.getNewsComment().size();

    threeLastNews.add(newsListFull.get(newsListFull.size() - 2));
    threeLastNews.add(newsListFull.get(newsListFull.size() - 3));
    threeLastNews.add(newsListFull.get(newsListFull.size() - 4));

    List<News> karuselNews = new ArrayList<>();
    for (int i = newsListFull.size() - 1; i >= 0; i--) {
      karuselNews.add(newsListFull.get(i));
    }
//        String checkUser = "offline"; // перевірка на то, чи юзер залогований, додаткова перевірка в chart.js
    int checkUser = 7;
    if (principalO instanceof UserDetails && !((UserDetails) principalO).getUsername()
        .equals("aa")) {
//             checkUser = "online";
      checkUser = 42;
    }

    //big news

    int newsId = newsLast.getId();
    String newsName = newsLast.getNewsName();
    String newsTime = newsLast.getNewsTime();
    String newsShort = newsLast.getNewsShort();
    String newsText = newsLast.getNewsText();
    String newsAuthor = newsLast.getNewsAuthor();
    if (futureNewsId != 42) { // значить був клік по новині -> в /newsPage futureNewsId = newsId
      newsId = futureNewsId;
      newsName = newsListFull.get(futureNewsId-1).getNewsName();
      newsTime = newsListFull.get(futureNewsId-1).getNewsTime();
      newsShort = newsListFull.get(futureNewsId-1).getNewsShort();
      newsText = newsListFull.get(futureNewsId-1).getNewsText();
      newsAuthor = newsListFull.get(futureNewsId-1).getNewsAuthor();
    }
    ///

    model.addAttribute("newsLast", newsLast);
    model.addAttribute("statusShowAll", statusService.findAll());
    model.addAttribute("newsShowAll", newsListFull);
    model.addAttribute("dtoVoting", dtoActiveVoting);
    model.addAttribute("user", byUsername);
    model.addAttribute("status", dtoActiveVoting.getVotingStatus());
    model.addAttribute("lastComments", lastComments);
    model.addAttribute("countOfComments", countOfComments);
    model.addAttribute("threeLastNews", threeLastNews);
    model.addAttribute("karuselNews", karuselNews);
    model.addAttribute("activeVotingId", dtoActiveVoting.getVotingId());
    model.addAttribute("checkUser", checkUser);
    model.addAttribute("newsId", newsId);
    model.addAttribute("newsName", newsName);
    model.addAttribute("newsTime", newsTime);
    model.addAttribute("newsShort", newsShort);
    model.addAttribute("newsText", newsText);
    model.addAttribute("newsAuthor", newsAuthor);
    return "index";
  }


  @GetMapping("/admin")
  public String loginAdm(Principal principal, Model model) {
    Object principalO = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    String userName = principalO instanceof UserDetails ? principal.getName() : "adminqweewq";
    //Треба буде і принципал переписати, перегести його в клас Юзера

    UserDetails byUsername = userService.loadUserByUsername(userName);
    List<News> newsListFull = newsService.findALL(); // Оцей метод наповнює ліст голосувань
    List<Voting> votingList = votingService.findALL();

    DTOActiveVoting dtoActiveVoting = DTOActiveVoting.createDTOAV(votingList, userName);

    model.addAttribute("user", byUsername);
    model.addAttribute("statusShowAll", statusService.findAll());
    model.addAttribute("newsLast", News.getLastNews(newsListFull));
    model.addAttribute("newsListTree", News.getThreeLastNews(newsListFull));
    model.addAttribute("newsShowAll", newsListFull);
    model.addAttribute("dtoVoting", dtoActiveVoting);
    model.addAttribute("status", dtoActiveVoting.getVotingStatus());
    return "admin";
  }

  @GetMapping(value = "/login")
  public String login(String logout) {

    if (logout != null) {
      return "index";
    }
    return "login";
  }

  @GetMapping(value = "/registration")
  public String registration(Model model) {
    model.addAttribute("userForm", new User());

    return "registration";
  }

  @RequestMapping(value = "/registration", method = RequestMethod.POST)
  public String registration(@ModelAttribute("userForm") User userForm,
      BindingResult bindingResult) {

    userValidator.validate(userForm, bindingResult);

    if (bindingResult.hasErrors()) {
      return "registration";
    }

    userService.save(userForm);

    return "redirect:/";
  }

  @GetMapping("/logout")
  public String logout() {
    return "redirect:/index";
  }

  @GetMapping("/cabinet")
  public String cabinet(Model model, Principal principal) {

    User byUsername = userService.findByUsername(principal.getName());
    model.addAttribute("User", byUsername);
    return "cabinet";
  }

  @GetMapping("newsPage-{id}")
  public String newsPage(@PathVariable("id") int id, Model model) {
    model.addAttribute("News", newsService.findOne(id));
    futureNewsId = id;
    model.addAttribute("newsId", id);
    return "redirect:/";
  }
}
