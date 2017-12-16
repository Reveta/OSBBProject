package ua.somedomen.osbb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.somedomen.osbb.entity.securityEntity.User;
import ua.somedomen.osbb.service.NewsService;
//import ua.somedomen.osbb.service.SecurityService;
import ua.somedomen.osbb.service.UserService;
import ua.somedomen.osbb.service.VotingService;
import ua.somedomen.osbb.validator.UserValidator;

import java.security.Principal;

@Controller
public class PagesController {

    @Autowired
    private UserService userService;

//    @Autowired
//    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private VotingService votingService;

    @Autowired
    private NewsService newsService;


    @GetMapping("/")
    //Не можу вивести принципал, просто тому, що по дефолту немає людини в сесії,
    //принаймні я так думаю. Хочу надіслати дані про авторизованого користувача
    // і добаляти його як власника коментаря.
    public String index(Model model, Principal principal) {
//        User user = userService.findByUsername(principal.getName());
//        model.addAttribute("user", principal.getName());

        Object currentUser = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (currentUser instanceof UserDetails) {
            String username = ((UserDetails) currentUser).getUsername();
        } else {
            String username = currentUser.toString();
        }

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
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult /*, @RequestParam("username") String name,
                               @RequestParam("password") String password,
                               @RequestParam("passwordConfirm") String passwordConfirm */){

        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(userForm);

//        securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());

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

    @GetMapping("/newsPage")
    public String newsPage(){
        return "newsPage";

    }

}
