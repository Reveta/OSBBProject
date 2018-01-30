package ua.somedomen.osbb.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Cascade;
import ua.somedomen.osbb.entity.securityEntity.User;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@Setter
@Getter
@ToString(exclude = "users")
public class Voting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String votingName;
    private String votingShort;
    private String votingText;
    private String votingTime;

    private int votingTrue;
    private int votingFalse;


//    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinTable(name = "users_votes", joinColumns = @JoinColumn(name = "Voting_id"),
//            inverseJoinColumns = @JoinColumn(name = "User_id"))
//    private Set<User> users;

    @ManyToMany( /*cascade = CascadeType.ALL,*/ /*cascade =
            {
                    CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.REFRESH,
                    CascadeType.PERSIST
            }, */fetch = FetchType.EAGER  /* targetEntity = User.class */)
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.REFRESH})
    @JoinTable(name = "USERS_VOTINGS_TRUE",
            inverseJoinColumns = @JoinColumn(name = "users_id"),
            joinColumns = @JoinColumn(name = "votings_id"))
    private Set<User> users = new LinkedHashSet<>();


//    public Voting(String votingName, String votingShort, String votingText, String votingTime, int votingTrue, int votingFalse, Set<User> users) {
//        this.votingName = votingName;
//        this.votingShort = votingShort;
//        this.votingText = votingText;
//        this.votingTime = votingTime;
//        this.votingTrue = votingTrue;
//        this.votingFalse = votingFalse;
//        this.users = users;
//    }

    public Voting(String votingName, String votingShort, String votingText, String votingTime, int votingTrue, int votingFalse) {
        this.votingName = votingName;
        this.votingShort = votingShort;
        this.votingText = votingText;
        this.votingTime = votingTime;
        this.votingTrue = votingTrue;
        this.votingFalse = votingFalse;
    }

//    @Override
//    public int hashCode() {
//        final int prime = 31;
//        int result = 1;
//        result = prime * result + (int) (id ^ (id >>> 32));
//        return result;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj)
//            return true;
//        if (obj == null)
//            return false;
//        if (!(obj instanceof Voting))
//            return false;
//        Voting other = (Voting) obj;
//        if (id != other.id)
//            return false;
//        return true;
//    }


    //    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Voting voting = (Voting) o;
//
//        if (id != voting.id) return false;
//        if (votingTrue != voting.votingTrue) return false;
//        if (votingFalse != voting.votingFalse) return false;
//        if (votingName != null ? !votingName.equals(voting.votingName) : voting.votingName != null) return false;
//        if (votingShort != null ? !votingShort.equals(voting.votingShort) : voting.votingShort != null) return false;
//        if (votingText != null ? !votingText.equals(voting.votingText) : voting.votingText != null) return false;
//        if (votingTime != null ? !votingTime.equals(voting.votingTime) : voting.votingTime != null) return false;
//        return users != null ? users.equals(voting.users) : voting.users == null;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = id;
//        result = 31 * result + (votingName != null ? votingName.hashCode() : 0);
//        result = 31 * result + (votingShort != null ? votingShort.hashCode() : 0);
//        result = 31 * result + (votingText != null ? votingText.hashCode() : 0);
//        result = 31 * result + (votingTime != null ? votingTime.hashCode() : 0);
//        result = 31 * result + votingTrue;
//        result = 31 * result + votingFalse;
//        result = 31 * result + (users != null ? users.hashCode() : 0);
//        return result;
//    }
}

