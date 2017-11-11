package ua.somedomen.osbb.service.securityService;


import ua.somedomen.osbb.entity.securityEntity.User;

import java.util.List;

public interface UserService
{
    void save(User user);
    List<User> findAll();
    User findByUsername(String name);
}
