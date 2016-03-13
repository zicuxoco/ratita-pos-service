package com.ratita.pos.serialization;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * A Mixin class that modifies how Offer are deserialized.
 *
 * @author z.martinez.ramirez on 12/03/2016.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonDeserialize(builder = RatitaProductOfferBuilder.class)
public class RatitaOfferMixin {
}
