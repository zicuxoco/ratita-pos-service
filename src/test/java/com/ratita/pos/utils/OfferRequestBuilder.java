package com.ratita.pos.utils;

import com.ratita.pos.rules.OfferClient;

import java.util.Collections;
import java.util.List;

import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author z.martinez.ramirez on 12/03/2016.
 *         This class is used by to simulate a request to web service
 */
public class OfferRequestBuilder {

    private static final String GUID = "4a4bda67-f89c-4038-933b-47093d660ba5";
    private static final String PRODUCT_ID = "1835020";
    private static final String PRODUCT_ID_PARAM = "id";
    private static final String TRANSACTION_ID_PARAM = "Transaction-Id";
    private static final String KEY_PARAM = "key";

    private boolean useTransactionId;

    private OfferClient offerClient;
    private WebTarget webTarget;

    public OfferRequestBuilder(OfferClient offerClient) {
        this.offerClient = offerClient;
    }

    public OfferRequestBuilder getClient(String key) {
        webTarget = offerClient.getOfferTarget()
            .queryParam(KEY_PARAM, key);
        return this;
    }

    public OfferRequestBuilder withTxIdHeader() {
        useTransactionId = true;
        return this;
    }

    public OfferRequestBuilder withProductIds(List<String> productIds) {
        webTarget = webTarget.queryParam(PRODUCT_ID_PARAM, productIds.toArray());
        return this;
    }

    public OfferRequestBuilder withDefaultHotelId() {
        return withProductIds(Collections.singletonList(PRODUCT_ID));
    }

    public Response getResponse() {
        Invocation.Builder builder = webTarget.request(MediaType.APPLICATION_JSON_TYPE);

        return useTransactionId ? builder.header(TRANSACTION_ID_PARAM, GUID).get() : builder.get();
    }
}
