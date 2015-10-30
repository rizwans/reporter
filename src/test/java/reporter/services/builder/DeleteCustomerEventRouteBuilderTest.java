package reporter.services.builder;

import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.test.spring.CamelSpringJUnit4ClassRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;

import java.util.Map;

import static org.junit.Assert.assertEquals;


@RunWith(CamelSpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/spring/applicationContext-test.xml"})
public class DeleteCustomerEventRouteBuilderTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Produce(uri = "activemq:reporter.queue")
    private ProducerTemplate producerTemplate;

    @Test
    public void testDeleteCustomerEventIsProcessedSuccessfully() throws InterruptedException {
        producerTemplate.sendBodyAndHeader("{\"customerId\":5}", "eventName", "deleteCustomerEvent");

        Thread.sleep(100L);
        Map<String, Object> resultsMap = jdbcTemplate.queryForMap("select * from CUSTOMER_EVENTS_AUDIT where id = ?", 5);
        assertEquals("deleteCustomerEvent", resultsMap.get("EVENT_NAME"));
    }
}
