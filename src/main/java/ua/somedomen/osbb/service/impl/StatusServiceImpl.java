package ua.somedomen.osbb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.somedomen.osbb.dao.StatusDAO;
import ua.somedomen.osbb.entity.Status;
import ua.somedomen.osbb.service.StatusService;

import java.util.List;

@Service
@Transactional
public class StatusServiceImpl implements StatusService {

    @Autowired
    private StatusDAO statusDAO;

    @Override
    public Status save(Status status) {

        return statusDAO.save(status);
    }

    @Override
    public List<Status> findAll() {
        return statusDAO.findAll();
    }

    @Override
    public void delete(int id) {
        statusDAO.delete(id);
    }

    @Override
    public Status findOne(int id) {
        return statusDAO.findOne(id);
    }
}