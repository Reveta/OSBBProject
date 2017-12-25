package ua.somedomen.osbb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.somedomen.osbb.dao.StatusDAO;
import ua.somedomen.osbb.entity.Status;
import ua.somedomen.osbb.service.StatusService;

import java.util.List;

@Service
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
}
