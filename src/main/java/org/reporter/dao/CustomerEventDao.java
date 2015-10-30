package org.reporter.dao;

public interface CustomerEventDao  {

    void store(Integer customerId, String eventName);

}
