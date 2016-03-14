package com.ratita.pos.resources;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.ratita.pos.restApi.domain.OfferBuilder;
import com.ratita.pos.restApi.domain.PromoType;
import com.ratita.pos.restApi.domain.SiteType;

import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

/**
 * @author z.martinez.ramirez on 13/03/2016.
 */
@JsonPOJOBuilder(buildMethodName = "createRatitaOffer", withPrefix = "set")
public class RatitaOfferBuilder extends OfferBuilder {
    @JsonProperty("RateRuleID")
    @Override
    public OfferBuilder setPromoId(long rateRuleId) {
        return super.setPromoId(rateRuleId);
    }

    @JsonProperty("SKUGroupID")
    @Override
    public OfferBuilder setRatitaProductId(long ratitaProductId) {
        return super.setRatitaProductId(ratitaProductId);
    }

    @Override
    public OfferBuilder setPromoDescription(String promoDescription) {
        return super.setPromoDescription(promoDescription);
    }

    @Override
    public OfferBuilder setDescriptionId(int descriptionId) {
        return super.setDescriptionId(descriptionId);
    }

    @Override
    public OfferBuilder setIsPackage(boolean isPackage) {
        return super.setIsPackage(isPackage);
    }

    @JsonProperty("AdjustmentTypeID")
    @Override
    public OfferBuilder setPromoType(PromoType promoType) {
        return super.setPromoType(promoType);
    }

    @JsonProperty("AdjustmentPrice")
    @Override
    public OfferBuilder setPromoValue(String promoValue) {
        return super.setPromoValue(promoValue);
    }

    @JsonProperty("siteTypes")
    public OfferBuilder setSiteTypesFromInt(Set<Integer> siteTypes) {
        boolean containMobile = false;
        long numberOfTypes = 0;

        SiteType type;
        for (Integer typeId : siteTypes) {
            if (typeId != null) {
                numberOfTypes ++;
                type = SiteType.valueOf(typeId);
                containMobile = containMobile || type == SiteType.Mobile;
            }
        }

        return super.setSiteType(
            containMobile  ? SiteType.Mobile : null);
    }


    /**
     * Sets the directAgencyOnly variable by checking all of the rate plans and determining if
     * *all* of them apply only to direct agency.
     * @param ratePlans The rate plans to check
     * @return This.
     */
    @JsonProperty("RatePlans")
    public OfferBuilder setDirectAgencyOnly(Map<String, String>[] ratePlans) {
        super.setDirectAgencyOnly(
            ratePlans != null
            && ratePlans.length > 0
            && Stream
            .of(ratePlans)
            .map(values -> values.get("RatePlanBusinessModelMask"))
            .allMatch("2"::equals));
        return this;
    }
}
