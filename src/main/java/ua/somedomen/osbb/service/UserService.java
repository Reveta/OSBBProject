package ua.somedomen.osbb.service;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetails;
import ua.somedomen.osbb.entity.securityEntity.User;

import java.util.List;

public interface UserService {
    void save(User user);
    void saveWithoutPassword(User user);

    List<User> findAll();

    User findByUsername(String name);
    User findOne(int id);

    UserDetails loadUserByUsername(String userName);

}
