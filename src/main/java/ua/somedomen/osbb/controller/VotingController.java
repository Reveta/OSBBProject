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

import java.security.Principal;
import java.util.Date;
import java.util.List;

@Controller
public class VotingController {

    @Autowired
    private VotingService votingService;

    @Autowired
    private UserService userService;





    @PostMapping("/addVote")
    public String addVote(
            @RequestParam int votingId,
//            @RequestParam int userId,/
//            @RequestParam String userName,
            Principal principal,
            @RequestParam String vote) {


//        User user= userService.findByUsername(userName);
        User user = userService.findByUsername(principal.getName());
        Voting thisVoting = votingService.findOne(votingId);


        List<Vote> voteList = thisVoting.getVoteList();
        voteList.add(new Vote(thisVoting, user, vote));

        thisVoting.setVoteList(voteList);

        System.out.println("Користувач  "+ user + "проголосував" + vote + "для " + thisVoting + ". ");

        votingService.save(thisVoting);

        return "redirect:/";
    }


}