package org.reporter.services;

import org.reporter.dao.CustomerEventDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EventServiceActivator {

    @Autowired
    private CustomerEventDao customerEventDao;


    public void handle(Integer id, String eventName) {
        customerEventDao.store(id, eventName);
    }
}
