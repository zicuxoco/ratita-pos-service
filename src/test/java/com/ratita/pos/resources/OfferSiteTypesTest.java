package com.ratita.pos.resources;

import com.ratita.pos.categories.Functional;
import com.ratita.pos.domain.Offer;
import com.ratita.pos.restApi.domain.SiteType;
import com.ratita.pos.rules.OfferClient;
import com.ratita.pos.utils.OfferRequestBuilder;
import com.ratita.pos.utils.OfferServiceEndpoint;

import java.util.Arrays;
import java.util.function.Consumer;

import javax.ws.rs.core.Response;

import org.apache.http.HttpStatus;
import org.hamcrest.MatcherAssert;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.hamcrest.CoreMatchers.either;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

/**
 * @author z.martinez.ramirez on 13/03/2016.
 * Test functional to test that the site type in the response
 * matched with the hope
 */
@Category(Functional.class)
public class OfferSiteTypesTest {

    private static final OfferServiceEndpoint OFFER_SERVICE_ENDPOINT = new OfferServiceEndpoint();
    private static final String MOBILE_RATES_OFF_KEY = "352001";
    private static final String MOBILE_RATES_KEY = "401043";

    @ClassRule
    public static OfferClient CLIENT = new OfferClient(OFFER_SERVICE_ENDPOINT);

    private static OfferRequestBuilder requestBuilder;

    @BeforeClass
    public static void setup() {
        requestBuilder = new OfferRequestBuilder(CLIENT);
    }

    @Test
    public void testOffer_WithMobileRatesReturnsSiteType() {
        Response response = requestBuilder.getClient(MOBILE_RATES_KEY).withDefaultHotelId().getResponse();

        assertResponse(response);

        Offer[] offers = response.readEntity(Offer[].class);

        assertOffers(offers, d -> assertThat(d.getSiteType(),
            either(is(equalTo(SiteType.Mobile))).or(is(nullValue()))));
    }

    @Test
    public void testDeals_WithOutMobileRatesReturnsNullSiteType() {
        Response response = requestBuilder.getClient(MOBILE_RATES_OFF_KEY).withDefaultHotelId().getResponse();

        assertResponse(response);

        Offer[] offers = response.readEntity(Offer[].class);

        assertOffers(offers, d -> MatcherAssert.assertThat(d.getSiteType(), is(nullValue())));
    }

    private void assertResponse(Response response) {
        assertThat(response, is(notNullValue()));
        assertThat(response.getStatus(), is(equalTo(HttpStatus.SC_OK)));
    }

    private void assertOffers(Offer[] offers, Consumer<Offer> assertion) {
        assertThat(offers, is(notNullValue()));
        Arrays.stream(offers).forEach(assertion);
    }
}
