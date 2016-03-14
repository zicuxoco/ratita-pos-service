package com.ratita.pos.resources;

import com.ratita.pos.domain.Offer;
import com.ratita.pos.custom.OfferCustomClient;

import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author z.martinez.ramirez on 09/03/2016.
 */
@Path(value = "/offer")
public class OfferResource {
    private final BiFunction<Set<Long>, OfferRequest, Stream<Offer>> offerFetcher;
    private final OfferCustomClient pzClient;
    private final Function<String, Locale> localeResolver;

    public OfferResource(@NotNull BiFunction<Set<Long>, OfferRequest, Stream< Offer>> offerFetcher,
                         @NotNull Function<String, Locale> localeResolver,
                         @NotNull OfferCustomClient pzClient) {
        Objects.requireNonNull(offerFetcher, "PosResource cannot function without a product fetcher.");
        Objects.requireNonNull(localeResolver, "PosResource cannot function without a locale resolver.");
        Objects.requireNonNull(pzClient, "PosResource cannot function without a PZ Client.");
        this.offerFetcher = offerFetcher;
        this.localeResolver = localeResolver;
        this.pzClient = pzClient;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @IdParameterFilter.Id
    @KeyParameterFilter.Key
    public Response getOffers(
        @QueryParam("id") Set<Long> productIds,
        @QueryParam("locale") String isoString,
        @QueryParam("key") String posKey) {

        OfferRequest request = new OfferRequest(
            pzClient.getPosPermissions(posKey),
            localeResolver.apply(isoString),
            pzClient.getMobileDealsAllowed(posKey));

        return Response
            .ok()
            .entity(offerFetcher.apply(productIds, request).collect(Collectors.toList()))
            .build();
    }
}
