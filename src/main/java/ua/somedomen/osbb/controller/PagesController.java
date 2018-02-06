package ua.somedomen.osbb.controller;

import com.sun.xml.internal.ws.encoding.xml.XMLMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ua.somedomen.osbb.entity.securityEntity.User;
import ua.somedomen.osbb.service.*;
import ua.somedomen.osbb.validator.UserValidator;

import javax.xml.stream.events.Comment;
import java.security.Principal;


@Controller
public class PagesController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private VotingService votingService;

    @Autowired
    private NewsService newsService;

    @Autowired
    private StatusService statusService;

    @Autowired
    private CommentService commentService;


    //        Object currentUser = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        if (currentUser instanceof UserDetails) {
//            String username = ((UserDetails) currentUser).getUsername();
//        } else {
//            String username = currentUser.toString();
//        }
    @GetMapping("/")
//Працюємо над тим як виводити принціпал навіть якщо його немає, soon be end
    public String index(Model model, Principal principal) {
        Object principalO = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        String userName = principalO instanceof UserDetails ? principal.getName() : "adminqweewq";

        UserDetails byUsername = userService.loadUserByUsername(userName);


        model.addAttribute("user", byUsername);
        model.addAttribute("statusShowAll", statusService.findAll());
        model.addAttribute("votingShowAll", votingService.findALL());
        model.addAttribute("newsShowAll", newsService.findALL());
        return "index";
    }


    @GetMapping("/admin")
    public String loginAdm(Principal principal, Model model) {
        model.addAttribute("user", principal);
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
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {

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
        return "newsPage";
    }
}
