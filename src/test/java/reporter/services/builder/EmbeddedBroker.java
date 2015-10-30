package reporter.services.builder;


import org.apache.activemq.broker.BrokerService;
import org.apache.activemq.broker.TransportConnector;

import java.net.URI;
import java.net.URISyntaxException;

public class EmbeddedBroker {

    private BrokerService brokerService;
    private String name;
    private String url;

    public EmbeddedBroker(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public void startBroker() throws Exception {
        brokerService = new BrokerService();
        brokerService.setBrokerName(name);
        brokerService.addConnector(getTCPConnector());
        brokerService.deleteAllMessages();
        brokerService.start();
        brokerService.waitUntilStarted();
    }

    private TransportConnector getTCPConnector() throws URISyntaxException {
        TransportConnector connector = new TransportConnector();
        connector.setUri(new URI(url));
        return connector;
    }

    public void stopBroker() throws Exception {
        brokerService.stop();
        brokerService.waitUntilStopped();
    }


}
