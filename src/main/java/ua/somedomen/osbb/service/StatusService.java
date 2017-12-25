package ua.somedomen.osbb.service;

import ua.somedomen.osbb.entity.Status;

import java.util.List;


public interface StatusService {

    Status save (Status status);

    List<Status> findAll();
}
