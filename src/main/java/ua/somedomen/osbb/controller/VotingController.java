package ua.somedomen.osbb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.somedomen.osbb.entity.Vote;
import ua.somedomen.osbb.entity.Voting;
import ua.somedomen.osbb.entity.securityEntity.User;
import ua.somedomen.osbb.service.UserService;
import ua.somedomen.osbb.service.VoteService;
import ua.somedomen.osbb.service.VotingService;

import java.util.Date;
import java.util.List;

@Controller
public class VotingController {

    @Autowired
    private VotingService votingService;

    @Autowired
    private UserService userService;



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

    @PostMapping("/addVote")
    public String addVote(
            @RequestParam int votingId,
            @RequestParam int userId,
            @RequestParam String vote) {


        User user= userService.findOne(userId);
        Voting thisVoting = votingService.findOne(votingId);


        List<Vote> voteList = thisVoting.getVoteList();
        voteList.add(new Vote(thisVoting, user, vote));

        thisVoting.setVoteList(voteList);

        System.out.println("Користувач  "+ user + "проголосував" + vote + "для " + thisVoting + ". ");

        votingService.save(thisVoting);

        return "redirect:/";
    }

    @GetMapping("/disableVoting")
    public String disableVoting(){
        Voting.disableVoting(votingService);

        System.out.println("Всі голосування деактивовані");
        return "redirect:/";
    }
}
