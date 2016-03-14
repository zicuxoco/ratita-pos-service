package com.ratita.pos.domain;

import com.ratita.pos.restApi.domain.PromoType;
import com.ratita.pos.restApi.domain.SiteType;

/**
 * @author z.martinez.ramirez on 13/03/2016.
 */
public class RatitaOffer extends Offer {

    public RatitaOffer(long promoId,
                       long ratitaProductId,
                       String promoDescription,
                       int descriptionId,
                       boolean isPackage,
                       PromoType promoType,
                       String promoValue,
                       SiteType siteType,
                       boolean isDirectAgencyOnly) {
        super(siteType,
            promoId,
            ratitaProductId,
            promoDescription,
            descriptionId,
            isPackage,
            promoType,
            promoValue,
            isDirectAgencyOnly);
    }
}
