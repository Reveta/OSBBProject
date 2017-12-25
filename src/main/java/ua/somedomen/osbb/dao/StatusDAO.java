package ua.somedomen.osbb.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.somedomen.osbb.entity.Status;

public interface StatusDAO extends JpaRepository<Status, Integer>{
}
