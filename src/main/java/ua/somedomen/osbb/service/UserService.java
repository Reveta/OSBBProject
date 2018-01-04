package ua.somedomen.osbb.service;


import ua.somedomen.osbb.entity.securityEntity.User;

import java.util.List;

public interface UserService {
    void save(User user);
    List<User> findAll();
    User findByUsername(String name);

    User findOne(int id);

    void saveWithoutPassword(User user);

}
