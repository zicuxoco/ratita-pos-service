package com.ratita.pos.serialization;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ratita.pos.domain.Offer;

import javax.ws.rs.ext.ContextResolver;

/**
 * ContextResolver for (@Link com.ratita.pos.jersey.ObjectMapperProvider)
 * @author z.martinez.ramirez on 12/03/2016.
 */
public final class ObjectMapperProvider implements ContextResolver<ObjectMapper> {

    private static final ObjectMapper OBJECT_MAPPER = createObjectMapper();

    @Override
    public ObjectMapper getContext(final Class<?> type) {
        return OBJECT_MAPPER;
    }

    private static ObjectMapper createObjectMapper() {
        return new ObjectMapper()
            .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
            .setSerializationInclusion(JsonInclude.Include.NON_NULL)
            .addMixIn(Offer.class, RatitaOfferMixin.class);
    }
}
