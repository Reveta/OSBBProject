package ua.somedomen.osbb.dao.securityDAO;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.somedomen.osbb.entity.securityEntity.User;

public interface UserDAO extends JpaRepository<User,Integer> {

    @Query("from User u where u.username=:name")
    User findByUsername(@Param("name") String name);

//    @Query("Update")
}
