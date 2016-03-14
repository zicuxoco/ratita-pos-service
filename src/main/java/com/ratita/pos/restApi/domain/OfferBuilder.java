package com.ratita.pos.restApi.domain;

import com.ratita.pos.domain.Offer;
import com.ratita.pos.domain.RatitaOffer;

/**
 * @author z.martinez.ramirez on 12/03/2016.
 */
public class OfferBuilder {
    private long promoId;
    private long ratitaProductId;
    private String promoDescription;
    private int descriptionId;
    private boolean isPackage;
    private PromoType promoType;
    private String promoValue;
    private SiteType siteType;
    private boolean isDirectAgencyOnly;

    public static OfferBuilder from(Offer offer) {
        return new OfferBuilder()
            .setPromoId(offer.getPromoId())
            .setRatitaProductId(offer.getRatitaProductId())
            .setPromoDescription(offer.getPromoDescription())
            .setDescriptionId(offer.getDescriptionId())
            .setIsPackage(offer.isPackage())
            .setPromoType(offer.getPromoType())
            .setPromoValue(offer.getPromoValue())
            .setSiteType(offer.getSiteType())
            .setDirectAgencyOnly(offer.isDirectAgencyOnly());


    }

    public OfferBuilder setPromoId(long promoId) {
        this.promoId = promoId;
        return this;
    }

    public OfferBuilder setRatitaProductId(long ratitaProductId) {
        this.ratitaProductId = ratitaProductId;
        return this;
    }

    public OfferBuilder setPromoDescription(String promoDescription) {
        this.promoDescription = promoDescription;
        return this;
    }

    public OfferBuilder setDescriptionId(int descriptionId) {
        this.descriptionId = descriptionId;
        return this;
    }

    public OfferBuilder setIsPackage(boolean isPackage) {
        this.isPackage = isPackage;
        return this;
    }

    public OfferBuilder setPromoType(PromoType promoType) {
        this.promoType = promoType;
        return this;
    }

    public OfferBuilder setPromoValue(String promoValue) {
        this.promoValue = promoValue;
        return this;
    }

    public OfferBuilder setSiteType(SiteType siteType) {
        this.siteType = siteType;
        return this;
    }

    public OfferBuilder setDirectAgencyOnly(boolean isDirectAgencyOnly) {
        this.isDirectAgencyOnly = isDirectAgencyOnly;
        return this;
    }

    public long getPromoId() {
        return promoId;
    }

    public long getRatitaProductId() {
        return ratitaProductId;
    }

    public String getPromoDescription() {
        return promoDescription;
    }

    public int getDescriptionId() {
        return descriptionId;
    }

    public boolean isPackage() {
        return isPackage;
    }

    public PromoType getPromoType() {
        return promoType;
    }

    public String getPromoValue() {
        return promoValue;
    }

   public Offer createRatitaOffer() {
        return new RatitaOffer(
            promoId, ratitaProductId, promoDescription, descriptionId, isPackage,
            promoType, promoValue, siteType, isDirectAgencyOnly);
    }
}
