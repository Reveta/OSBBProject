package ua.somedomen.osbb.entity.securityEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Cascade;
import org.hibernate.validator.constraints.Email;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ua.somedomen.osbb.entity.Voting;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = "votings")
public class User implements UserDetails
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;
//    @Column(updatable = false)
    private String password;
//    @Column(updatable = false)
    private String passwordConfirm;

    @Email(message = "Введіть email коректно")
    private String email;

    @ManyToMany( /* cascade =
            {
                    CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.REFRESH,
                    CascadeType.PERSIST
            }, */ fetch = FetchType.EAGER /* targetEntity = User.class */)
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.REFRESH})
    @JoinTable(name = "USERS_VOTINGS_TRUE",
            joinColumns = @JoinColumn(name = "users_id"),
            inverseJoinColumns = @JoinColumn(name = "votings_id"))
    private Set<Voting> votings = new LinkedHashSet<>();

    @Enumerated(EnumType.STRING)
    private Authority authority = Authority.ROLE_USER;

    private boolean accountNonExpired = true;
    private boolean accountNonLocked = true;
    private boolean credentialsNonExpired = true;
    private boolean enabled = true;

    private String name;
    private String prename;
    private String phoneNumber;

    private String someInfo;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities()
    {
        ArrayList<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(authority.name()));
        return authorities;
    }


    @Override
    public boolean isAccountNonExpired()
    {
        return accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked()
    {
        return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired()
    {
        return credentialsNonExpired;
    }

    @Override
    public boolean isEnabled()
    {
        return enabled;
    }


//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        User user = (User) o;
//
//        if (id != user.id) return false;
//        if (accountNonExpired != user.accountNonExpired) return false;
//        if (accountNonLocked != user.accountNonLocked) return false;
//        if (credentialsNonExpired != user.credentialsNonExpired) return false;
//        if (enabled != user.enabled) return false;
//        if (username != null ? !username.equals(user.username) : user.username != null) return false;
//        if (password != null ? !password.equals(user.password) : user.password != null) return false;
//        if (passwordConfirm != null ? !passwordConfirm.equals(user.passwordConfirm) : user.passwordConfirm != null)
//            return false;
//        if (email != null ? !email.equals(user.email) : user.email != null) return false;
//        if (votings != null ? !votings.equals(user.votings) : user.votings != null) return false;
//        if (authority != user.authority) return false;
//        if (name != null ? !name.equals(user.name) : user.name != null) return false;
//        if (prename != null ? !prename.equals(user.prename) : user.prename != null) return false;
//        if (phoneNumber != null ? !phoneNumber.equals(user.phoneNumber) : user.phoneNumber != null) return false;
//        return someInfo != null ? someInfo.equals(user.someInfo) : user.someInfo == null;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = id;
//        result = 31 * result + (username != null ? username.hashCode() : 0);
//        result = 31 * result + (password != null ? password.hashCode() : 0);
//        result = 31 * result + (passwordConfirm != null ? passwordConfirm.hashCode() : 0);
//        result = 31 * result + (email != null ? email.hashCode() : 0);
//        result = 31 * result + (votings != null ? votings.hashCode() : 0);
//        result = 31 * result + (authority != null ? authority.hashCode() : 0);
//        result = 31 * result + (accountNonExpired ? 1 : 0);
//        result = 31 * result + (accountNonLocked ? 1 : 0);
//        result = 31 * result + (credentialsNonExpired ? 1 : 0);
//        result = 31 * result + (enabled ? 1 : 0);
//        result = 31 * result + (name != null ? name.hashCode() : 0);
//        result = 31 * result + (prename != null ? prename.hashCode() : 0);
//        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
//        result = 31 * result + (someInfo != null ? someInfo.hashCode() : 0);
//        return result;
//    }
}
