package com.ratita.pos.resources;

import com.ratita.pos.categories.Functional;
import com.ratita.pos.domain.Offer;
import com.ratita.pos.rules.OfferClient;
import com.ratita.pos.utils.OfferRequestBuilder;
import com.ratita.pos.utils.PosServiceEndpoint;

import java.io.IOException;
import java.io.StringReader;
import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import org.apache.commons.csv.CSVFormat;
import org.apache.http.HttpStatus;
import org.hamcrest.core.IsEqual;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.hamcrest.Matchers.emptyArray;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author z.martinez.ramirez on 12/03/2016.
 */
@Category(Functional.class)
public class PosProductListCollectTest {

    private static final PosServiceEndpoint POS_SERVICE_ENDPOINT = new PosServiceEndpoint();
    private static final String PRODUCT_COLLECT_KEY = "123321";
    private static final String NON_PRODUCT_COLLECT_KEY = "321123";

    private static final String CACHE_PRODUCT_ID = "id";
    private static final String CACHE_DESCRIPTION = "description";
    private static final String CACHE_IS_PACKAGE = "isPackage";
    private static final String CACHE_NUMBER_OF_OFFERS = "number_of_offers";
    private static final String CACHE_DA_ONLY = "da_only_offers";

    private static List<String> directStoreAgencyIds;

    @ClassRule
    public static OfferClient CLIENT = new OfferClient(POS_SERVICE_ENDPOINT);

    @BeforeClass
    public static void prepareProductIdsFromCache() throws IOException {

        Response offerCacheResponse = CLIENT.getCacheTargetForPath(POS_SERVICE_ENDPOINT.getPosCachePath())
            .request()
            .header(HttpHeaders.ACCEPT_ENCODING, "gzip")
            .post(null);

        assertThat(offerCacheResponse, is(notNullValue()));
        assertThat(offerCacheResponse.getStatus(), is(IsEqual.equalTo(HttpStatus.SC_OK)));

        directStoreAgencyIds = CSVFormat
            .RFC4180
            .withHeader(CACHE_PRODUCT_ID, CACHE_DESCRIPTION, CACHE_IS_PACKAGE, CACHE_NUMBER_OF_OFFERS, CACHE_DA_ONLY)
            .withSkipHeaderRecord()
            .parse(new StringReader(offerCacheResponse.readEntity(String.class)))
            .getRecords()
            .stream()
            .filter(record -> Integer.parseInt(record.get(CACHE_DA_ONLY)) > 0
                && Integer.parseInt(record.get(CACHE_DA_ONLY)) <    Integer.parseInt(record.get(CACHE_NUMBER_OF_OFFERS)))
            .map(record -> record.get(CACHE_PRODUCT_ID))
            .collect(Collectors.toList());
    }

    @Test
    public void testOffers_ProductCollectVsNonProductCollect() {

        final String collectMessage = "from a product-collect key (" + PRODUCT_COLLECT_KEY + ")";
        final String nonCollectMessage = "from a non-product-collect key (" + NON_PRODUCT_COLLECT_KEY + ")";

        Response collectResponse = new OfferRequestBuilder(CLIENT)
            .getClient(PRODUCT_COLLECT_KEY)
            .withProductIds(directStoreAgencyIds)
            .getResponse();

        assertThat(collectResponse, is(notNullValue()));
        assertThat(collectResponse.getStatus(), is(HttpStatus.SC_OK));
        Offer[] collectOffers = collectResponse.readEntity(Offer[].class);
        assertThat("Response " + collectMessage + "should not be null.", collectOffers, is(notNullValue()));
        assertThat("Response " + collectMessage + "should not be empty.", collectOffers, is(not(emptyArray())));

    }


}
