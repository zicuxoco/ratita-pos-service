package com.ratita.pos.resources;

import com.ratita.pos.domain.Product;
import com.ratita.pos.pz.PosPzClient;

import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.validation.constraints.NotNull;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

/**
 * @author z.martinez.ramirez on 09/03/2016.
 */
@Path(value = "/pos")
public class PosResource {
    private final BiFunction<Set<Long>, PosRequest, Stream<Product>> productFetcher;
    private final PosPzClient pzClient;
    private final Function<String, Locale> localeResolver;

    public PosResource(@NotNull BiFunction<Set<Long>, PosRequest, Stream<Product>> productFetcher,
                       @NotNull Function<String, Locale> localeResolver,
                       @NotNull PosPzClient pzClient) {
        Objects.requireNonNull(productFetcher, "PosResource cannot function without a product fetcher.");
        Objects.requireNonNull(localeResolver, "PosResource cannot function without a locale resolver.");
        Objects.requireNonNull(pzClient, "PosResource cannot function without a PZ Client.");
        this.productFetcher = productFetcher;
        this.localeResolver = localeResolver;
        this.pzClient = pzClient;
    }

    public Response getPos(
        @QueryParam("id") Set<Long> productIds,
        @QueryParam("locale") String isoString,
        @QueryParam("key") String posKey) {

        PosRequest request = new PosRequest(
            pzClient.getPosPermissions(posKey),
            localeResolver.apply(isoString),
            pzClient.getMobileDealsAllowed(posKey));

        return Response
            .ok()
            .entity(productFetcher.apply(productIds, request).collect(Collectors.toList()))
            .build();
    }
}
