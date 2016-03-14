package com.ratita.pos.rules;

import com.ratita.pos.serialization.ObjectMapperProvider;
import com.ratita.pos.utils.OfferServiceEndpoint;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.apache.http.client.utils.URIBuilder;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.ClientProperties;
import org.glassfish.jersey.filter.LoggingFilter;
import org.junit.rules.ExternalResource;

/**
 * @author z.martinez.ramirez on 12/03/2016.
 * @Rule used for the implementation of service
 */
public class OfferClient extends ExternalResource {

    private static final String DEFAULT_SCHEME = "http";

    private final OfferServiceEndpoint endpoint;

    private Client offerClient;
    private WebTarget posTarget;
    private WebTarget adminTarget;

    public OfferClient(OfferServiceEndpoint endpoint) {
        this.endpoint = endpoint;
    }

    /**
     * (@inheritDoc)
     */
    @Override
    public void before()throws Throwable {
        ClientConfig clientConfig = new ClientConfig()
            .property(ClientProperties.READ_TIMEOUT, 50000)
            .property(ClientProperties.CONNECT_TIMEOUT, 2000);

        offerClient = ClientBuilder
            .newClient(clientConfig)
            .register(new LoggingFilter())
            .register(new ObjectMapperProvider());

        URIBuilder uriBuilder = new URIBuilder()
            .setHost(endpoint.getHost())
            .setScheme(DEFAULT_SCHEME);

        if (endpoint.getPort() > 0) {
            uriBuilder.setPort(endpoint.getPort());
        }

        posTarget = offerClient
            .target(uriBuilder.build())
            .path(endpoint.getPath());

        if (endpoint.getPort() > 0) {
            uriBuilder.setPort(endpoint.getAdminPort());
        }

        adminTarget = offerClient.target(uriBuilder.build());
    }

    @Override
    public void after() {
        if (offerClient != null) {
            offerClient.close();
        }
    }

    public WebTarget getOfferTarget() {
        return posTarget;
    }

    public WebTarget getCacheTargetForPath(String path) {
        return adminTarget.path(path);
    }

}
