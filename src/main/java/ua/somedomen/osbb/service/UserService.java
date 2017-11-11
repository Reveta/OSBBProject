package ua.somedomen.osbb.service;


import ua.somedomen.osbb.entity.User;

import java.util.List;

public interface UserService
{
    void save(User user);
    List<User> findAll();
    User findByUsername(String name);
}
