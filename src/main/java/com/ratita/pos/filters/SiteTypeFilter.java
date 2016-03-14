package com.ratita.pos.filters;

import com.ratita.pos.domain.Offer;
import com.ratita.pos.restApi.domain.SiteType;

import java.util.function.Predicate;

/**
 * @author z.martinez.ramirez on 13/03/2016.
 */
public class SiteTypeFilter implements Predicate<Offer> {
    private boolean mobileOfferAllowed;

    public SiteTypeFilter(boolean mobileOfferAllowed) {
        this.mobileOfferAllowed = mobileOfferAllowed;
    }

    @Override
    public boolean test(Offer offer) {

        SiteType type = offer.getSiteType();
        return SiteType.Agent != type && (type == null || (mobileOfferAllowed && SiteType.Mobile == type));
    }

}
