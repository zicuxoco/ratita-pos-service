package com.ratita.pos.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ratita.pos.restApi.domain.PromoType;
import com.ratita.pos.restApi.domain.SiteType;

/**
 * @author z.martinez.ramirez on 09/03/2016.
 */
public abstract class Offer {

    private final long promoId;
    private final long ratitaProductId;
    private final String promoDescription;
    private final int descriptionId;
    private final boolean isPackage;
    private final PromoType promoType;
    private final String promoValue;
    private final SiteType siteType;
    private boolean isDirectAgencyOnly;

    public Offer(SiteType siteType, long promoId, long ratitaProductId,
                 String promoDescription, int descriptionId, boolean isPackage,
                 PromoType promoType, String promoValue, boolean isDirectAgencyOnly) {
        this.siteType = siteType;
        this.promoId = promoId;
        this.ratitaProductId = ratitaProductId;
        this.promoDescription = promoDescription;
        this.descriptionId = descriptionId;
        this.isPackage = isPackage;
        this.promoType = promoType;
        this.promoValue = promoValue;
        this.isDirectAgencyOnly = isDirectAgencyOnly;
    }

    @JsonProperty
    public long getPromoId() {
        return promoId;
    }

    @JsonIgnore
    public long getRatitaProductId() {
        return ratitaProductId;
    }

    @JsonProperty
    public String getPromoDescription() {
        return promoDescription;
    }

    @JsonProperty("promoDescription")
    public int getDescriptionId() {
        return descriptionId;
    }

    @JsonIgnore
    public boolean isPackage() {
        return isPackage;
    }

    @JsonProperty("promoType")
    public PromoType getPromoType() {
        return promoType;
    }

    @JsonProperty("promoValue")
    public String getPromoValue() {
        return promoValue;
    }

    @JsonProperty("siteType")
    public SiteType getSiteType() {
        return siteType;
    }

    @JsonIgnore
    public boolean isDirectAgencyOnly() {
        return isDirectAgencyOnly;
    }
}
