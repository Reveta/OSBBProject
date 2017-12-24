package ua.somedomen.osbb.entity.securityEntity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Email;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Getter
@Setter
@ToString
public class User implements UserDetails
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;
    private String password;
    private String passwordConfirm;

    @Email(message = "Введіть email коректно")
    private String email;


    private String name;
    private String prename;
    private String phoneNumber;

    private String someInfo;

    public User() {
    }

    public User(String username, String password, String passwordConfirm, String email, String name, String prename, String phoneNumber, String someInfo) {
        this.username = username;
        this.password = password;
        this.passwordConfirm = passwordConfirm;
        this.email = email;
        this.name = name;
        this.prename = prename;
        this.phoneNumber = phoneNumber;
        this.someInfo = someInfo;
    }

    public User(String username, String password, String passwordConfirm) {
        this.username = username;
        this.password = password;
        this.passwordConfirm = passwordConfirm;
    }

    public User(String email, String name, String prename, String phoneNumber, String someInfo) {
        this.email = email;
        this.name = name;
        this.prename = prename;
        this.phoneNumber = phoneNumber;
        this.someInfo = someInfo;
    }

    private boolean accountNonExpired = true;
    private boolean accountNonLocked = true;
    private boolean credentialsNonExpired = true;
    private boolean enabled = true;



    @Enumerated(EnumType.STRING)
    private Authority authority = Authority.ROLE_USER;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities()
    {
        ArrayList<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(authority.name()));
        return authorities;
    }

    @Override
    public String getPassword()
    {
        return password;
    }

    @Override
    public String getUsername()
    {
        return username;
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

    public Authority getAuthority()
    {
        return authority;
    }

    public void setAuthority(Authority authority)
    {
        this.authority = authority;
    }

    public void setAccountNonExpired(boolean accountNonExpired)
    {
        this.accountNonExpired = accountNonExpired;
    }

    public void setAccountNonLocked(boolean accountNonLocked)
    {
        this.accountNonLocked = accountNonLocked;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired)
    {
        this.credentialsNonExpired = credentialsNonExpired;
    }

}