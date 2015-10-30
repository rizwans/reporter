package org.reporter.services.builder;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.reporter.model.DeleteCustomerEvent;
import org.reporter.services.EventServiceActivator;
import org.springframework.beans.factory.annotation.Autowired;

public class DeleteCustomerEventRouteBuilder extends RouteBuilder {

    @Autowired
    private EventServiceActivator eventServiceActivator;


    @Override
    public void configure() throws Exception {

        from("activemq:reporter.queue")
                .filter(header("eventName").isEqualTo("deleteCustomerEvent"))
                    .unmarshal()
                    .json(JsonLibrary.Jackson, DeleteCustomerEvent.class)
                        .bean(eventServiceActivator, "handle(${body.customerId},${header.eventName})");
    }
}
