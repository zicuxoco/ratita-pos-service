package com.ratita.pos.resources;

import com.ratita.pos.categories.Unit;
import com.ratita.pos.domain.Offer;
import com.ratita.pos.custom.OfferCustomClient;

import java.util.List;
import java.util.Locale;
import java.util.function.Function;
import java.util.stream.Stream;

import javax.ws.rs.core.Response;

import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.ExpectedException;

import static org.hamcrest.Matchers.emptyCollectionOf;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author z.martinez.ramirez on 09/03/2016.
 */
@Category(Unit.class)
public class OfferResourceTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void test_Construct_Null_Everything() throws Exception {
        expectedException.expect(NullPointerException.class);
        expectedException.expectMessage("fetcher");
        new OfferResource(null, null, null);
    }

    @Test
    public void test_Construct_Null_Fetcher() throws Exception {
        expectedException.expect(NullPointerException.class);
        expectedException.expectMessage("fetcher");
        new OfferResource(null, locale -> null, mock(OfferCustomClient.class));
    }

    @Test
    public void test_Construct_Null_Resolver() throws Exception {
        expectedException.expect(NullPointerException.class);
        expectedException.expectMessage("resolver");
        new OfferResource((ids, request) -> null, null, mock(OfferCustomClient.class));
    }

    @Test
    public void test_Construct_Null_PZClient() throws Exception {
        expectedException.expect(NullPointerException.class);
        expectedException.expectMessage("PZ");
        new OfferResource((ids, request) -> null, locale -> null, null);
    }

    @Test
    public void test_Retrieve_Pos() throws Exception {
        Function<String, Locale> resolver = locale -> Locale.CANADA;
        OfferCustomClient client = mock(OfferCustomClient.class);
        when(client.getMobileDealsAllowed(anyString())).thenReturn(true);
        when(client.getPosPermissions(anyString())).thenReturn(1);
        OfferResource resource = new OfferResource((ids, request) -> Stream.empty(), resolver, client);

        Response response = resource.getOffers(null, null, null);
        assertThat((List<Offer>) response.getEntity(), emptyCollectionOf(Offer.class));
    }
}
