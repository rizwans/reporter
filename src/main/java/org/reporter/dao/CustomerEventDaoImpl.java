package org.reporter.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerEventDaoImpl implements CustomerEventDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void store(Integer customerId, String eventName) {
        jdbcTemplate.update("INSERT INTO CUSTOMER_EVENTS_AUDIT (ID,EVENT_NAME) VALUES (?,?)",customerId, eventName);
    }
}
